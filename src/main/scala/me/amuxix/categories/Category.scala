package me.amuxix.categories

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix._
import me.amuxix.providers.Provider

trait Category extends ImplicitConversions with Named {
  protected def categoryBlocks(provider: Provider): FilterLevel => NonEmptyList[Block]

  def blocks(filterLevel: FilterLevel, provider: Provider): IO[NonEmptyList[Block]] = Mergeable.parMerge(categoryBlocks(provider)(filterLevel))

  protected def writeBlockWithSeparator(blocks: List[Block], filterLevel: FilterLevel): String =
    if (blocks.isEmpty) { "" }
    else { separator + blocks.sortBy(_.rarity)(implicitly[Ordering[FilterRarity]].reverse).map(_.write(filterLevel)).mkString("", "\n", "\n") }

  def partitionHiddenAndShown(filterLevel: FilterLevel, provider: Provider): IO[(String, String)] = blocks(filterLevel, provider).map { blocks =>
    val (shown, hidden) = blocks.toList.partition(_.show(filterLevel))
    (writeBlockWithSeparator(shown, filterLevel), writeBlockWithSeparator(hidden, filterLevel))
  }

  def separator: String = {
    val asterisks = "*" * (59 - className.length / 2)
    s"#$asterisks $className $asterisks\n"
  }
}
