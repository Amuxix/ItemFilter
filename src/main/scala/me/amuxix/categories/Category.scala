package me.amuxix.categories

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix._

trait Category extends ImplicitConversions with Named {
  protected def categoryBlocks(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): FilterLevel => IO[NonEmptyList[Block]]

  def blocks(filterLevel: FilterLevel, prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): IO[NonEmptyList[Block]] =
    categoryBlocks(prices, parentLeaguePrices)(filterLevel).map(Mergeable.merge(_))

  protected def writeBlockWithSeparator(blocks: List[Block], filterLevel: FilterLevel): String =
    if (blocks.isEmpty) ""
    else
      separator + blocks.sortBy(_.rarity)(implicitly[Ordering[FilterRarity]].reverse).map(_.write(filterLevel)).mkString("", "\n", "\n")

  def partitionHiddenAndShown(filterLevel: FilterLevel, conceal: Boolean, prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): IO[(String, String)] =
    blocks(filterLevel, prices, parentLeaguePrices).map { blocks =>
      val (shown, hidden) = blocks.map(_.concealed(conceal, filterLevel)).toList.partition(_.show(filterLevel))
      (writeBlockWithSeparator(shown, filterLevel), writeBlockWithSeparator(hidden, filterLevel))
    }

  def separator: String = {
    val asterisks = "*" * (59 - className.length / 2)
    s"#$asterisks $className $asterisks\n"
  }
}
