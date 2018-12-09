package me.amuxix.categories.automated.currency

import me.amuxix.FilterRarity
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

object Abyss extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem { override protected def condition: Condition = Condition(base = Seq("Eye Jewel", "Stygian Vise")) }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45, borderColor = Color.slimeGreen)
}
