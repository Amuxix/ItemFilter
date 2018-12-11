package me.amuxix.categories.automated.currency

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.items.GenItem
import me.amuxix.items.currency.Essence.essences
import me.amuxix.{Epic, FilterRarity, Mythic}

object Essence extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = essences
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Mythic =>
      Action(
        size = 45,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen,
        textColor = Color.black
      )
    case Epic =>
      Action(size = 40,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen.darken,
        textColor = Color.black
      )
    case _ =>
      Action(
        textColor = Color.slimeGreen
      )
  }
}
