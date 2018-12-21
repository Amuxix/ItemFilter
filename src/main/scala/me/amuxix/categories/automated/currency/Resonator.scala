package me.amuxix.categories.automated.currency

import me.amuxix.FilterRarity
import me.amuxix.actions.Color.{delveBlue, legacyBlue}
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.items.GenItem

object Resonator extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = resonators
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(
    size = 40,
    borderColor = legacyBlue,
    textColor = legacyBlue,
    backgroundColor = delveBlue,
    minimapIcon = (Blue, Circle),
  )
}
