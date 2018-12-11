package me.amuxix.categories.automated

import me.amuxix.FilterRarity
import me.amuxix.actions.{Action, Color}
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}

object Breach extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new CategoryItem { override protected def condition: Condition = Condition(base = "Breach Ring") }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45, borderColor = Color.darkRed, backgroundColor = Color.black, textColor = Color.purple)
}
