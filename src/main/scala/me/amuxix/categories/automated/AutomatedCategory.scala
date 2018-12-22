package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.categories.Category
import me.amuxix.items.GenItem
import me.amuxix.{Block, FilterLevel, FilterRarity}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

trait AutomatedCategory extends Category {
  protected val categoryItems: Future[Seq[GenItem]]
  protected def actionForRarity(rarity: FilterRarity): Action
  /*
  rarity match {
    case AlwaysHide =>
    case Leveling =>
    case Trash =>
    case Common =>
    case Uncommon =>
    case Rare =>
    case Epic =>
    case Mythic =>
    case AlwaysShow =>
    case Undetermined =>
  }
   */

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] =
    Await.result(categoryItems, Duration.Inf)
      .sortBy(_.rarity)(implicitly[Ordering[FilterRarity]].reverse)
      .map(_.block(actionForRarity, filterLevel))
}
