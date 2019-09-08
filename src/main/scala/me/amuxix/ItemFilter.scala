package me.amuxix

import cats.data.NonEmptyList
import cats.implicits._
import javax.swing.filechooser.FileSystemView
import me.amuxix.WSClient.getActorSystemAndWsClient
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
import me.amuxix.providers.Provider
import me.amuxix.providers.poeninja.PoeNinja
import org.flywaydb.core.Flyway
import pureconfig.generic.auto._
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import java.io.{File, PrintWriter}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Failure

object ItemFilter {
  //TODO Keep price history
  //TODO Fallback price from parent league
  val league: League = Blight
  implicit val ec = ExecutionContext.global
  val config = pureconfig.loadConfigOrThrow[FilterConfiguration]("filter")
  val cutoffs = config.levelCutoffs
  val dbgConfig = pureconfig.loadConfigOrThrow[DatabaseConfiguration]("db")
  lazy val db = Database.forURL(
    url = dbgConfig.url,
    user = dbgConfig.user,
    password = dbgConfig.password,
    driver = dbgConfig.driver,
  )
  val (system, wsClient) = getActorSystemAndWsClient
  val provider: Provider = new PoeNinja(wsClient)

  def runMigrations() = {
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

  /*def main(args: Array[String]): Unit = {
    Bases.bestItems.map(_.map(println))
  }*/

  //val poeFolder = new java.io.File(".").getCanonicalPath
  /*provider.itemPrices.foreach { items =>
    val prices = items.toSeq.sortBy(_._2).map {
      case (name, price) => s"${name.capitalize} -> $price"
    }.mkString("\n")
    println(prices)
  }*/

  def main(args: Array[String]): Unit = {
    runMigrations()
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar

    //TODO show items with white sockets
    val categories = NonEmptyList.of(
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

    val legacyCategories = NonEmptyList.of(
      Net,
      Legacy,
    )

    List(Reduced, Diminished, Normal, Racing).traverse { level =>
      createFilterFile(poeFolder, level, NonEmptyList(categories.head, categories.tail), legacyCategories)
    //createFilterFile(poeFolder, level, categories, legacyCategories, conceal = true)
    } andThen {
      case _ =>
        wsClient.close()
        system.terminate()
    } andThen {
      case Failure(ex) => throw ex
    }
  }

  def createFilterFile(
    poeFolder: String,
    filterLevel: FilterLevel,
    categories: NonEmptyList[Category],
    legacyCategories: NonEmptyList[Category],
    conceal: Boolean = false
  ): Future[Unit] = {
    val allCategories = if (league == Standard || league == Hardcore) {
      categories.concatNel(legacyCategories)
    } else {
      categories
    }
    for {
      (shown, hidden) <- allCategories.traverse(_.partitionHiddenAndShown(filterLevel, conceal)).map(_.toList.unzip)
      lastCallBlocks <- LastCall.blocks(filterLevel)
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
