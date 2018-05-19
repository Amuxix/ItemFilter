package me.amuxix.categories

import me.amuxix._

abstract class Category extends ImplicitConversions with Named {
  protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def blocks(filterLevel: FilterLevel): Seq[Block] = Mergeable.merge(categoryBlocks(filterLevel))
  def partitionHiddenAndShown(filterLevel: FilterLevel): (String, String) = {
    def addSeparatorAndMakeString(blocks: Seq[Block]) = {
      separator + blocks.map(_.write).mkString("", "\n", "\n")
    }
    blocks(filterLevel).partition(_.show) match {
      case (shown, Seq()) => (addSeparatorAndMakeString(shown), "")
      case (shown, hidden) => (addSeparatorAndMakeString(shown), addSeparatorAndMakeString(hidden))
    }
  }

  protected def separator: String = {
    val asterisks = "*"  * (59 - name.length / 2)
    s"#$asterisks $name $asterisks\n"
  }
}
