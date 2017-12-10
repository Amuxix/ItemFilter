package me.amuxix

import java.io.{File, PrintWriter}
import javax.swing.filechooser.FileSystemView

import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._

object ItemFilter {
  def main(args: Array[String]): Unit = {
    val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar

    val categories: Seq[Category] = Seq(
      Myths, General, Gems, Essence, Talisman, Abyss, Breach, Legacy, Harbinger, Currency, Maps,
      Uniques, Jewels, DivinationCards, Atlas, Chisel, Chromatic, Regal, Chaos, Flasks, Leveling, LastCall
    )

    Seq(Reduced, Normal, Racing).foreach(createFilterFile(poeFolder, _, categories))
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category]): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + "Amuxix's " + filterLevel.suffix + ".new.filter"))
    val strings: Seq[String] = categories.map(_.writeCategory(filterLevel))
    filterFile.write(strings.mkString("", "\n", "\nHide"))
    filterFile.close()
  }
}
