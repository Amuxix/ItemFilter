package me.amuxix.categories

import me.amuxix.{Block, FilterLevel, ImplicitConversions, Mergeable}

abstract class Category extends ImplicitConversions {
  def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def writeCategory(filterLevel: FilterLevel): String = {
    Mergeable.merge(categoryBlocks(filterLevel)).map(_.write).mkString("\n")
  }
}
