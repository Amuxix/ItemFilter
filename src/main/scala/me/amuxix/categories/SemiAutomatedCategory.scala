package me.amuxix.categories
import me.amuxix.actions.Action
import me.amuxix.items.GenItem
import me.amuxix.{Block, FilterLevel, FilterRarity}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

trait SemiAutomatedCategory extends Category {
  protected val categoryItems: Future[Seq[GenItem]]
  protected def actionForRarity: FilterRarity => Action
  /*
  rarity match {
    case AlwaysHide =>
    case Leveling =>
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
      .map(_.block(actionForRarity))
}
