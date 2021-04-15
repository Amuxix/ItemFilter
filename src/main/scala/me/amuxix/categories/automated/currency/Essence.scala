package me.amuxix.categories.automated.currency

import cats.data.NonEmptyList
import me.amuxix.{Epic, Mythic, Priced}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object Essence extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.essences.all
  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen,
        textColor = Color.black
      )
    case Epic =>
      Action(size = 40, borderColor = Color.black, backgroundColor = Color.slimeGreen.darken, textColor = Color.black)
    case _ =>
      Action(
        textColor = Color.slimeGreen
      )
  }
}
