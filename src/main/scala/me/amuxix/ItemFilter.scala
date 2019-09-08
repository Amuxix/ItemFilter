package me.amuxix

import cats.data.NonEmptyList
import cats.effect.{ContextShift, ExitCode, IO, IOApp}
import cats.effect.ExitCode.Success
import cats.implicits._
import javax.swing.filechooser.FileSystemView
import me.amuxix.categories._
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
import me.amuxix.providers.PoeNinja
import org.flywaydb.core.Flyway
import org.http4s.client.blaze.BlazeClientBuilder
import pureconfig.generic.auto._
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import java.io.{File, PrintWriter}
import scala.concurrent.ExecutionContext

object ItemFilter extends IOApp {
  override implicit val contextShift: ContextShift[IO] = super.contextShift
  implicit val ec = ExecutionContext.global
  val config = pureconfig.loadConfigOrThrow[FilterConfiguration]("filter")
  val cutoffs = config.levelCutoffs
  lazy val db = Database.forConfig("db")
  lazy val httpClientResource = BlazeClientBuilder[IO](ec).resource

  val league: League = Temporary("Blight")

  val runMigrations = IO {
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
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar

    //TODO show items with white sockets
    def getCategories(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) = NonEmptyList.of(
      General,
      Essence,
      Fossil,
      Oil,
      ChaoticResonators,
      AlchemicalResonators,
      Scarabs,
      MapFragments,
      new Currency(prices, parentLeaguePrices),
      Gems,
      Incursion,
      DivinationCard,
      new Uniques(prices, parentLeaguePrices),
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
      new Chromatic(prices, parentLeaguePrices),
      Bauble,
      new Whetstone(prices, parentLeaguePrices),
      new Scrap(prices, parentLeaguePrices),
      Jewels,
      Flasks,
      Maps,
      Prophecies,
      Incubators,
      Emblems,
      LevelingCategory,
    )

    val legacyCategories = NonEmptyList.of(
      Net,
      Legacy,
    )

    def createFiles(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) = List(Reduced, Diminished, Normal, Racing)
      .traverse_ { level =>
        val categories = getCategories(prices, parentLeaguePrices)
        createFilterFile(poeFolder, level, NonEmptyList(categories.head, categories.tail), legacyCategories, prices, parentLeaguePrices)
        //createFilterFile(poeFolder, level, categories, legacyCategories, prices, parentLeaguePrices, conceal = true)
      }
    for {
      _ <- runMigrations
      (prices, parentLeaguePrices) <- BlazeClientBuilder[IO](ec).resource.use { client =>
        val provider = new PoeNinja(client)
        for {
          prices <- provider.getAllItemsPrices(league)
          parentLeaguePrices <- league.parent.fold(IO.pure(Map.empty[String, Double]))(league => provider.getAllItemsPrices(league))
        } yield (prices, parentLeaguePrices)
      }
      _ <- createFiles(prices, parentLeaguePrices)
    } yield Success
  }

  def createFilterFile(
    poeFolder: String,
    filterLevel: FilterLevel,
    categories: NonEmptyList[Category],
    legacyCategories: NonEmptyList[Category],
    prices: Map[String, Double],
    parentLeaguePrices: Map[String, Double],
    conceal: Boolean = false,
  ): IO[Unit] = {
    val allCategories = if (league == Standard || league == Hardcore) {
      categories.concatNel(legacyCategories)
    } else {
      categories
    }
    for {
      (shown, hidden) <- allCategories.traverse(_.partitionHiddenAndShown(filterLevel, conceal, prices, parentLeaguePrices)).map(_.toList.unzip)
      lastCallBlocks <- LastCall.blocks(filterLevel, prices, parentLeaguePrices)
      lastCall = lastCallBlocks.map(_.write(filterLevel))
      filterName = s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter"
      filterFile = new PrintWriter(new File(poeFolder + s"$filterName.filter"))
    } yield {
      println(s"Generating $filterName")
      filterFile.write((shown ++ hidden ++ lastCall.toList).mkString)
      filterFile.close()
    }
  }
}
