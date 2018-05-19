package me.amuxix

import java.io.{File, PrintWriter}

import javax.swing.filechooser.FileSystemView
import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._

object ItemFilter {
  def main(args: Array[String]): Unit = {
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    //val currentDirectory = new java.io.File(".").getCanonicalPath

    val categories: Seq[Category] = Seq(
      Myths, General, Gems, Essence, Talisman, Beastiary, Abyss, Breach, Legacy, Harbinger, Currency, Maps,
      Uniques, Jewels, DivinationCards, ShaperAndElder, BestBases, Atlas, Chisel, Regal, Chaos, Chromatic, TwentyQuality, Flasks, Leveling
    )
    //println(currentDirectory.toString)
    Seq(Reduced, Normal, Racing).foreach(createFilterFile(poeFolder, _, categories))
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category]): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + "Amuxix's" + filterLevel.suffix + " filter.filter"))
    val (shown, hidden) = categories.map(_.partitionHiddenAndShown(filterLevel)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.blocks(filterLevel).map(_.write)).mkString("", "\n", "\n"))
    filterFile.close()
  }
}
