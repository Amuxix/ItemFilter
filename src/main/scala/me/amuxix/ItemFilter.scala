package me.amuxix

import cats.data.NonEmptyList
import cats.effect.{ExitCode, IO, IOApp, Resource}
import cats.implicits._
import javax.swing.filechooser.FileSystemView
//import me.amuxix.categories._
import me.amuxix.categories.automated._
import me.amuxix.categories.automated.currency._
import me.amuxix.categories.automated.mapfragments.{Emblems, Scarabs}
import me.amuxix.categories.manual.leagues._
import me.amuxix.categories.manual.recipes._
import me.amuxix.categories.semiautomated._
import me.amuxix.categories.semiautomated.currency._
import me.amuxix.categories.semiautomated.recipes._
import me.amuxix.categories.single._
import me.amuxix.categories.single.legacy._
import me.amuxix.database.PostgresProfile.api.Database
import me.amuxix.providers.{PoeNinja, Provider}
import org.flywaydb.core.Flyway
import org.http4s.client.blaze.BlazeClientBuilder
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import java.io.{File, PrintWriter}
import scala.concurrent.ExecutionContext

object ItemFilter extends IOApp {
  //TODO Keep price history
  //TODO Fallback price from parent league
  val league: League = Metamorph
  implicit val ec = ExecutionContext.global
  val config = FilterSettings.fromConfig()
  val cutoffs = config.levelCutoffs
  lazy val db = Database.forConfig("db")

  var provider: Provider = _

  def runMigrations(): Unit = {
    val ds = db.source match {
      case d: DataSourceJdbcDataSource => d.ds
      case d: HikariCPJdbcDataSource   => d.ds
      case other =>
        throw new IllegalStateException("Unknown DataSource type: " + other)
    }
    val flyway = Flyway.configure().dataSource(ds).baselineOnMigrate(true).load()

    val migrations = flyway.migrate()
    println(s"Ran $migrations migrations.")
  }

  override def run(args: List[String]): IO[ExitCode] = {
    runMigrations()
    lazy val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar

    //TODO show items with white sockets
    lazy val categories = NonEmptyList.of(
      General,
      Essence,
      Fossil,
      Oil,
      ChaoticResonators,
      AlchemicalResonators,
      Scarabs,
      MapFragments,
      Currency,
      Gems,
      Incursion,
      DivinationCard,
      Uniques,
      VeiledItems,
      BreachRings, //TODO: Add to base types, merge with accessories
      Abyss,       //TODO: Add to base types, merge with accessories/jewels
      Talisman,
      Synthesized,
      Rares,
      Enchanted,
      Atlas,
      //TODO: Add corrupted items
      Chisel,
      Regal,
      Chaos,
      Chromatic,
      Bauble,
      Whetstone,
      Scrap,
      Jewels,
      Flasks,
      Maps,
      Prophecies,
      Incubators,
      Emblems,
      LevelingCategory,
    )
    lazy val legacyCategories = NonEmptyList.of(
      Net,
      Legacy,
    )

    for {
      (client, finalizer) <- BlazeClientBuilder[IO](ec).resource.allocated
      _ = provider = new PoeNinja(client, league)
      factory = new FilterFactory(league, categories, legacyCategories)
      filters <- List(Reduced, Diminished, Normal, Racing).traverse(factory.create)
      _ <- filters.traverse_(writeFilterFile(poeFolder, _))
      _ <- finalizer
    } yield ExitCode.Success
  }

  private def writer(poeFolder: String, filterName: String): Resource[IO, PrintWriter] =
    Resource.fromAutoCloseable(IO {
      new PrintWriter(new File(poeFolder + s"$filterName.filter"))
    })

  private def writeFilterFile(poeFolder: String, filter: FilterFactory#Filter): IO[Unit] =
    writer(poeFolder, filter.name).use(writer => IO(writer.write(filter.body)))
}
