package me.amuxix.categories

import cats.data.NonEmptyList
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.items.GenItem
import me.amuxix.{Block, FilterLevel, FilterRarity}

import scala.concurrent.Future

trait SemiAutomatedCategory extends Category {
  protected val categoryItems: Future[NonEmptyList[GenItem]]
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

  override protected def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]] = { _ =>
    categoryItems.flatMap(_.traverse(_.block(actionForRarity)))
  }
}
