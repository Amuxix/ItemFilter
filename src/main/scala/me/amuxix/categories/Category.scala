package me.amuxix.categories

import me.amuxix.{Block, FilterLevel}

abstract class Category {
  def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def writeCategory(filterLevel: FilterLevel): String = {
    categoryBlocks(filterLevel).map(_.write).mkString("\n")
  }
}
