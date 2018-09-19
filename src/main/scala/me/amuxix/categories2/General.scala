package me.amuxix.categories2
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

object General extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem() { override protected def condition: Condition = Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")), },
    new GenItem() { override protected def condition: Condition = ??? },
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = ???
}
