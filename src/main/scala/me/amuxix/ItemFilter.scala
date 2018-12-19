package me.amuxix

import java.io.{File, PrintWriter}

import akka.actor.ActorSystem
import me.amuxix.WSClient.wsClient
import me.amuxix.categories._
import me.amuxix.categories.automated._
import me.amuxix.database.PostgresProfile.api.Database
import me.amuxix.providers.poeninja.PoeNinja
import org.flywaydb.core.Flyway
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import pureconfig.generic.auto._
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object ItemFilter {
  val league: League = Betrayal
  val config = pureconfig.loadConfigOrThrow[FilterConfiguration]("filter")
  val cutoffs = config.levelCutoffs
  val dbgConfig = pureconfig.loadConfigOrThrow[DatabaseConfiguration]("db")
  lazy val db = Database.forURL(
    url = dbgConfig.url,
    user = dbgConfig.user,
    password = dbgConfig.password,
    driver = dbgConfig.driver,
  )

  def updateItemPrices(): (ActorSystem, StandaloneAhcWSClient) = {
    val (system, client) = wsClient
    val provider = new PoeNinja(client)
    val f = provider.getAllItemsPrices
    Await.result(f, 10 seconds)
    println("Prices updated")
    (system, client)
  }

  def runMigrations() = {
    val ds = db.source match {
      case d: DataSourceJdbcDataSource => d.ds
      case d: HikariCPJdbcDataSource => d.ds
      case other => throw new IllegalStateException("Unknown DataSource type: " + other)
    }
    val flyway = Flyway
      .configure()
      .dataSource(ds)
      .baselineOnMigrate(true)
      .load()

    val migrations = flyway.migrate()

    println(s"Ran $migrations migrations.")
  }

  def main(args: Array[String]): Unit = {
    runMigrations()
    //print((weapons ++ armours ++ flasks ++ accessories).flatten.map(_.insertValues).mkString(",\n"))
  }

  /*def main(args: Array[String]): Unit = {
    val (system, client) = updateItemPrices()
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    //val poeFolder = new java.io.File(".").getCanonicalPath
    lazy val prices = Provider.itemPrices.toSeq.sortBy(_._2).map {
      case (name, price) => s"${name.capitalize} -> $price"
    }.mkString("\n")
    println(prices)

    //TODO show items with white sockets
    val categories: Seq[Category] = Seq(
      General,
      Essence,
      Fossil,
      Resonator,
      Scarab,
      Fragment,
      Currency,
      Gems,
      Incursion,
      DivinationCard,
      Uniques,
      VeiledItems,
      Breach, //TODO: Add to base types, merge with accessories
      Abyss, //TODO: Add to base types, merge with accessories/jewels
      Talisman,
      Shaper,
      Elder,
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
      Prophecy,
    )

    val legacyCategories = Seq(
      Net,
      Legacy,
    )

    Seq(Reduced, Diminished, Normal, Racing).foreach((filterLevel: FilterLevel) => createFilterFile(poeFolder, filterLevel, categories, legacyCategories))
    createFilterFile(poeFolder, Reduced, categories, legacyCategories, conceal = true)
    client.close()
    system.terminate()
  }*/

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], legacyCategories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val allCategories = if (league == Standard || league == Hardcore) {
      categories ++ legacyCategories
    } else {
      categories
    }
    val (shown, hidden) = allCategories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.blocks(filterLevel).reverse.map(_.write)).mkString)
    filterFile.close()
  }
}
