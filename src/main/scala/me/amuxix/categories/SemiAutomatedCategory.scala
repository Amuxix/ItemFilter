package me.amuxix.categories

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

trait SemiAutomatedCategory extends Category {
  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem]
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

  override protected def categoryBlocks(provider: Provider): FilterLevel => NonEmptyList[Block] = _ => categoryItems(provider).map(_.block(provider, actionForRarity))
}
