package me.amuxix.categories

import me.amuxix._

trait Category extends ImplicitConversions with Named {
  protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def blocks(filterLevel: FilterLevel): Seq[Block] = Mergeable.merge(categoryBlocks(filterLevel))

  private def addSeparatorAndMakeString(blocks: Seq[Block]): String =
    blocks.headOption.fold("") { _ =>
      separator + blocks.map(_.write).mkString("", "\n", "\n")
    }

  def partitionHiddenAndShown(filterLevel: FilterLevel, conceal: Boolean): (String, String) = {
    val (shown, hidden) = blocks(filterLevel).map(_.concealed(conceal)).partition(_.show)
    (addSeparatorAndMakeString(shown), addSeparatorAndMakeString(hidden))
  }

  def separator: String = {
    val asterisks = "*" * (59 - name.length / 2)
    s"#$asterisks $name $asterisks\n"
  }
}
