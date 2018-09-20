package me.amuxix

import java.io.{File, PrintWriter}

import me.amuxix.WSClient.wsClient
import me.amuxix.categories2._
//import me.amuxix.categories2.Category
import me.amuxix.items.Item
import me.amuxix.providers.poeninja.PoeNinja

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object ItemFilter {
  val threshold = 0.1

  def updateItemPrices(): Unit = {
    val (system, client) = wsClient
    implicit val provider = new PoeNinja(client)
    val f = provider
      .getAllItemsPrices()
      .andThen { case _ => client.close() }
      .andThen { case _ => system.terminate() }
    Await.result(f, 30 seconds)
  }

  def main(args: Array[String]): Unit = {
    updateItemPrices()
    /*val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    //val poeFolder = new java.io.File(".").getCanonicalPath

    val categories: Seq[Category] = Seq(
      Myths,
      General,
      Gems,
      Essence,
      Talisman,
      Beastiary,
      Abyss,
      Breach,
      Legacy,
      Harbinger,
      Incursion,
      Delve,
      Currency,
      Maps,
      Uniques,
      Jewels,
      DivinationCards,
      ShaperAndElder,
      BestBases,
      Atlas,
      Leveling,
      Chisel,
      Regal,
      Chaos,
      Chromatic,
      TwentyQuality,
      Flasks
    )
    //println(currentDirectory.toString)
    Seq(Reduced, Normal, Racing).foreach(createFilterFile(poeFolder, _, categories))
    createFilterFile(poeFolder, Reduced, categories, conceal = true)*/
    //println(Mergeable.merge(Item.items.map(_.block)).map(_.write).mkString)
  }

/*  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val (shown, hidden) = categories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.write).mkString)
    filterFile.close()
  }*/
}
