package me.amuxix.categories
import me.amuxix.{Block, FilterLevel}
import me.amuxix.items.Item

trait AutomatedCategory extends Category {
  val categoryItems: Seq[Item]

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = categoryItems.collect {
    case item if item.rarity >= filterLevel.cutoffRarity => item.block
  }
}
