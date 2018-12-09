package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.categories.Category
import me.amuxix.items.GenItem
import me.amuxix.{Block, FilterLevel, FilterRarity}

trait AutomatedCategory extends Category {
  protected val categoryItems: Seq[GenItem]
  protected def actionForRarity(rarity: FilterRarity): Action
  /*
  rarity match {
    case Mythic =>
    case Epic =>
    case Rare =>
    case Uncommon =>
    case Common =>
    case Leveling =>
    case Undetermined =>
    case AlwaysShow =>
    case AlwaysHide =>
  }
   */

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = categoryItems.map(_.block(actionForRarity, filterLevel))
}
