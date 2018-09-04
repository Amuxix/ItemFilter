package me.amuxix

import java.io.{File, PrintWriter}

import javax.swing.filechooser.FileSystemView
import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._

object ItemFilter {
  def main(args: Array[String]): Unit = {
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
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
    createFilterFile(poeFolder, Reduced, categories, conceal = true)
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val (shown, hidden) = categories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.write).mkString)
    filterFile.close()
  }
}
