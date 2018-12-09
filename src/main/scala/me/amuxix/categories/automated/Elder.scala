package me.amuxix.categories.automated

import me.amuxix.actions.{Action, Color}
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.{AlwaysShow, FilterRarity}

object Elder extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem(AlwaysShow) { override protected def condition: Condition = Condition(elderItem = true) }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(backgroundColor = Color.shelder)
}

