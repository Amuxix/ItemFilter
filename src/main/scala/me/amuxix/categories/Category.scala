package me.amuxix.categories

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

trait Category extends ImplicitConversions with Named {
  protected def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]]

  def blocks(filterLevel: FilterLevel): Future[NonEmptyList[Block]] =
    categoryBlocks(filterLevel)
      .flatMap { items =>
        Future(Mergeable.parMerge(items))
      }

  protected def writeBlockWithSeparator(blocks: List[Block], filterLevel: FilterLevel): String =
    if (blocks.isEmpty) {
      ""
    } else {
      separator + blocks.sortBy(_.rarity)(implicitly[Ordering[FilterRarity]].reverse).map(_.write(filterLevel)).mkString("", "\n", "\n")
    }

  def partitionHiddenAndShown(filterLevel: FilterLevel): Future[(String, String)] =
    blocks(filterLevel).map { blocks =>
      val (shown, hidden) = blocks.toList.partition(_.show(filterLevel))
      (writeBlockWithSeparator(shown, filterLevel), writeBlockWithSeparator(hidden, filterLevel))
    }

  def separator: String = {
    val asterisks = "*" * (59 - className.length / 2)
    s"#$asterisks $className $asterisks\n"
  }
}
