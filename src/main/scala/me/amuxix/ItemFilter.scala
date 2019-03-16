package me.amuxix

import java.io.{File, PrintWriter}

import javax.swing.filechooser.FileSystemView
import me.amuxix.WSClient.getActorSystemAndWsClient
import me.amuxix.categories._
import me.amuxix.categories.automated._
import me.amuxix.categories.automated.currency._
import me.amuxix.categories.automated.leagues._
import me.amuxix.categories.automated.leagues.betrayal._
import me.amuxix.categories.automated.legacy._
import me.amuxix.categories.automated.recipes._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._
import me.amuxix.database.PostgresProfile.api.Database
import me.amuxix.providers.Provider
import me.amuxix.providers.poeninja.PoeNinja
import org.flywaydb.core.Flyway
import pureconfig.generic.auto._
import slick.jdbc.DataSourceJdbcDataSource
import slick.jdbc.hikaricp.HikariCPJdbcDataSource

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

object ItemFilter {
  val league: League = Synthesis
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
  val (system, client) = getActorSystemAndWsClient
  val provider: Provider = new PoeNinja(client)

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

  /*def main(args: Array[String]): Unit = {
    //runMigrations()
  }*/

  def main(args: Array[String]): Unit = {
    runMigrations()
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    //val poeFolder = new java.io.File(".").getCanonicalPath
    /*lazy val prices = Provider.itemPrices.toSeq.sortBy(_._2).map {
      case (name, price) => s"${name.capitalize} -> $price"
    }.mkString("\n")*/
    //println(prices)

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
      Fractured,
      Synthesised,
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
      Prophecy,
    )

    val legacyCategories = Seq(
      Net,
      Legacy,
    )

    Seq(Reduced, Diminished, Normal, Racing).foreach { level =>
      createFilterFile(poeFolder, level, categories, legacyCategories)
      //createFilterFile(poeFolder, level, categories, legacyCategories, conceal = true)
    }
    client.close()
    system.terminate()
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], legacyCategories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterName = s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter"
    val filterFile = new PrintWriter(new File(poeFolder + s"$filterName.filter"))
    println(s"Generating $filterName")
    val allCategories = if (league == Standard || league == Hardcore) {
      categories ++ legacyCategories
    } else {
      categories
    }
    val (shown, hidden) = allCategories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    val lastCall = LastCall.blocks(filterLevel).map(_.write(filterLevel))
    filterFile.write((shown ++ hidden ++ lastCall).mkString)
    filterFile.close()
  }
}
