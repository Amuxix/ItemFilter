package me.amuxix.categories2
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenItem, Item}

object Atlas extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem { override protected def condition: Condition = Condition(base = Seq("Steel Ring", "Opal Ring", "Crystal Belt")) }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45)
}
