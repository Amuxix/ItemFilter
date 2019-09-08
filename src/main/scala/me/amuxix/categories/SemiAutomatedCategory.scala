package me.amuxix.categories

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.{Block, FilterLevel, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.items.GenericItem

trait SemiAutomatedCategory extends Category {
  protected val categoryItems: IO[NonEmptyList[GenericItem]]
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

  override protected def categoryBlocks(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): FilterLevel => IO[NonEmptyList[Block]] = { _ =>
    categoryItems.flatMap(_.traverse(_.block(actionForRarity, prices: Map[String, Double], parentLeaguePrices: Map[String, Double])))
  }
}
