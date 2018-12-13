package me.amuxix

import java.io.{File, PrintWriter}

import akka.actor.ActorSystem
import javax.swing.filechooser.FileSystemView
import me.amuxix.WSClient.wsClient
import me.amuxix.categories._
import me.amuxix.categories.automated._
import me.amuxix.categories.automated.currency._
import me.amuxix.categories.automated.leagues._
import me.amuxix.categories.automated.leagues.betrayal.{Scarab, VeiledItems}
import me.amuxix.categories.automated.legacy.Net
import me.amuxix.categories.automated.recipes._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._
import me.amuxix.providers.Provider
import me.amuxix.providers.poeninja.PoeNinja
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object ItemFilter {
  val threshold = 0.04
  val league: League = Betrayal
  val whiteCutoff: Int = 15
  val magicCutoff: Int = 30
  val fourLinkRareCutoff: Int = 60
  val setDropLevelCutoff: Int = 50
  val weaponClasses = Seq(
    "Claw",
    "Dagger",
    "Wand",
    "Sword",
    "Bow",
    "Stave",
    "Axe",
    "Mace",
    "Quiver",
    "Sceptre",
  )
  val armourClasses = Seq(
    "Glove",
    "Boot",
    "Body Armour",
    "Helmet",
  )
  val accessoriesClasses = Seq(
    "Ring",
    "Belt",
    "Amulet",
  )
  val shieldClasses = Seq("Shield")
  val flaskClasses = Seq("Flask")

  def updateItemPrices(): (ActorSystem, StandaloneAhcWSClient) = {
    val (system, client) = wsClient
    val provider = new PoeNinja(client)
    val f = provider.getAllItemsPrices
    Await.result(f, 10 seconds)
    println("Prices updated")
    (system, client)
  }

  def main(args: Array[String]): Unit = {
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
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], legacyCategories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val allCategories = if (league == Standard || league == Hardcore) {
      categories ++ legacyCategories
    } else {
      categories
    }
    val (shown, hidden) = allCategories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.blocks(filterLevel).map(_.write)).mkString)
    filterFile.close()
  }
}
