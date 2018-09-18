package me.amuxix.categories2.currency

import me.amuxix.FilterRarity
import me.amuxix.actions.Color.{delveBlue, legacyBlue}
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.categories2.AutomatedCategory
import me.amuxix.items.GenItem
import me.amuxix.items.currency.delve.Resonator.resonators

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
