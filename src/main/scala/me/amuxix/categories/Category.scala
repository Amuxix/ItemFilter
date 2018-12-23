package me.amuxix.categories
import me.amuxix._

trait Category extends ImplicitConversions with Named {
  protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def blocks(filterLevel: FilterLevel): Seq[Block] =
    Mergeable.merge(categoryBlocks(filterLevel).toList)

  protected def writeBlockWithSeparator(blocks: Seq[Block], filterLevel: FilterLevel): String =
    if (blocks.isEmpty) ""
    else separator + blocks.sortBy(_.rarity)(implicitly[Ordering[FilterRarity]].reverse).map(_.write(filterLevel)).mkString("", "\n", "\n")

  def partitionHiddenAndShown(filterLevel: FilterLevel, conceal: Boolean): (String, String) = {
    val (shown, hidden) = blocks(filterLevel).map(_.concealed(conceal, filterLevel)).partition(_.show(filterLevel))
    (writeBlockWithSeparator(shown, filterLevel), writeBlockWithSeparator(hidden, filterLevel))
  }

  def separator: String = {
    val asterisks = "*" * (59 - name.length / 2)
    s"#$asterisks $name $asterisks\n"
  }
}
