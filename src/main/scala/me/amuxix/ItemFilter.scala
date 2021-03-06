package me.amuxix

import cats.data.NonEmptyList
import cats.effect.{IO, IOApp, Resource}
import cats.implicits._
import javax.swing.filechooser.FileSystemView
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
import me.amuxix.providers.items.ItemProvider
import me.amuxix.providers.prices.{PoeNinja, PriceProvider}
import me.amuxix.providers.Provider
import org.flywaydb.core.Flyway
import org.http4s.client.blaze.BlazeClientBuilder
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import java.io.{File, PrintWriter}

object ItemFilter extends IOApp.Simple {
  //TODO Keep price history
  //TODO Fallback price from parent league
  val league: League = Ultimatum
  val settings = FilterSettings.fromConfig()
  val cutoffs = settings.levelCutoffs
  lazy val db = Database.forConfig("db")

  def runMigrations: IO[Unit] = {
    val ds = db.source match {
      case d: DataSourceJdbcDataSource => d.ds
      case d: HikariCPJdbcDataSource   => d.ds
      case other                       => throw new IllegalStateException(s"Unknown DataSource type: $other")
    }
    val flyway = Flyway.configure.dataSource(ds).baselineOnMigrate(true).load
    IO(flyway.migrate()).flatMap(migrations => IO.println(s"Ran ${migrations.migrationsExecuted} migrations."))
  }

  override def run: IO[Unit] = {
    lazy val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar

    //TODO show items with white sockets
    lazy val categories = NonEmptyList.of(
      General,
      Essence,
      DeliriumOrb,
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
      BreachRings,
      ClusterJewels,
      Abyss,
      Talisman,
      Synthesized,
      MetamorphSample,
      Influenced,
      Rares,
      //TODO Add all fractured and influenced items maybe?
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
      Emblems, //TODO: Extract metamorph samples into its own category
      LevelingCategory,
      Watchstone,
      Heist,
    )
    lazy val legacyCategories = NonEmptyList.of(Net, Legacy)

    for {
      _ <- runMigrations
      ec <- IO.executionContext
      (client, finalizer) <- BlazeClientBuilder[IO](ec).resource.allocated
      priceProvider <- PriceProvider.fromProvider(new PoeNinja(client, league))
      itemProvider <- ItemProvider.fromDB
      provider = new Provider(priceProvider, itemProvider)
      factory = new FilterFactory(league, categories, legacyCategories, provider)
      filters <- List(Reduced, Diminished, Normal, Racing).traverse(factory.create)
      //_ <- filters.traverse_(uploadToGGG(client, _))
      _ <- filters.traverse_(writeFilterFile(poeFolder, _))
      _ <- finalizer
    } yield ()
  }

  /*private def getSecurityHash(client: Client[IO], uri: Uri): IO[String] = {
    val hashRegex: Regex = ".+<input type=\"hidden\" name=\"hash\" value=\"([0-9a-z-]+)\">.+".r
    for {
      //requestWithHeader = request.withHeaders(Cookie(NonEmptyList.one(RequestCookie("cookie", settings.ggg.cookie))))
      response <- client.run(GET.apply(uri)).use {
        case response if response.status.isSuccess =>
          println(response)
          response.as[String]
      }
    } yield response match {
      case hashRegex(hash) =>
        println(hash)
        hash
      case other =>
        println(other)
        other
    }
  }

  private def uploadToGGG(client: Client[IO], filter: FilterFactory#Filter): IO[Unit] = {
    val uri = settings.ggg.uri / filter.level.id
    for {
      hash <- getSecurityHash(client, uri)
      multipart = Multipart[IO](Vector(
        Part.formData("filter_name", filter.name),
        Part.formData("platform", "pc"),
        Part.formData("public", "1"),
        Part.formData("description", ""),
        Part.formData("should_validate", "1"),
        Part.formData("filter", filter.body),
        Part.formData("copied_from", ""),
        Part.formData("hash", hash),
        Part.formData("submit", "Submit"),
      ))
      request = POST(multipart, uri)
      requestWithHeader = request.withHeaders(multipart.headers.toList :+ Cookie(NonEmptyList.one(RequestCookie("cookie", settings.ggg.cookie))): _*)
      response <- client.run(requestWithHeader).use { case response if response.status.isSuccess => response.as[String] }
    } yield () //println(response)
  }*/

  private def writer(poeFolder: String, filterName: String): Resource[IO, PrintWriter] = Resource.fromAutoCloseable(IO(new PrintWriter(new File(poeFolder + s"$filterName.filter"))))

  private def writeFilterFile(poeFolder: String, filter: FilterFactory#Filter): IO[Unit] = writer(poeFolder, filter.name).use(writer => IO(writer.write(filter.body)))
}
