package me.amuxix.categories2
import me.amuxix.actions.Action
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
    case Undetermined =>
  }
   */

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = categoryItems.map(_.block(actionForRarity, filterLevel))
}
