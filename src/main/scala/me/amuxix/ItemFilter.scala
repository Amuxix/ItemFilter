package me.amuxix

import java.io.{File, PrintWriter}

import akka.actor.ActorSystem
import javax.swing.filechooser.FileSystemView
import me.amuxix.WSClient.wsClient
import me.amuxix.categories.automated._
import me.amuxix.categories.automated.currency._
import me.amuxix.categories.automated.leagues.betrayal.{Scarab, VeiledItems}
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._
import me.amuxix.categories.{Category, _}
import me.amuxix.providers.poeninja.PoeNinja
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object ItemFilter {
  val threshold = 0.1

  def updateItemPrices(): (ActorSystem, StandaloneAhcWSClient) = {
    val (system, client) = wsClient
    implicit val provider = new PoeNinja(client)
    val f = provider
      .getAllItemsPrices()
    Await.result(f, 30 seconds)
    println("Prices updated")
    (system, client)
  }

  def main(args: Array[String]): Unit = {
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    val (system, client) = updateItemPrices()
    //val poeFolder = new java.io.File(".").getCanonicalPath
    val categories: Seq[Category] = Seq(
      General,
      Essence,
      Fossil,
      Resonator,
      Beastiary,
      Incursion,
      Scarab,
      Fragment,
      Currency,
      Gems,
      VeiledItems,
      Breach,
      Abyss,
      Talisman,
      Maps,
      Uniques,
      Jewels,
      DivinationCard,
      Shaper,
      Elder,
      Atlas,
      Chisel,
      Regal,
      Chaos,
      Chromatic,
      TwentyQuality,
      Flasks,
      Legacy,
    )
    Seq(Reduced, Normal, Racing).foreach(createFilterFile(poeFolder, _, categories))
    createFilterFile(poeFolder, Reduced, categories, conceal = true)
    client.close()
    system.terminate()
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val (shown, hidden) = categories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.blocks(filterLevel).map(_.write)).mkString)
    filterFile.close()
  }
}
