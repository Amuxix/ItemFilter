package me.amuxix.categories.automated.mapfragments

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.actions.Color.{delveOrange, scarabBlue}
import me.amuxix.actions.Sound.{epic, myths}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object Scarabs extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.mapFragments.scarabs
  private val baseAction = Action(
    textColor = delveOrange,
    borderColor = scarabBlue,
  )
  override protected def action: Priced => Action = {
    case Mythic =>
      baseAction.copy(
        size = 45,
        sound = myths,
        minimapIcon = (Blue, Circle),
        beam = Blue
      )
    case Epic =>
      baseAction.copy(
        size = 40,
        sound = epic,
        minimapIcon = (Blue, Circle),
        beam = Blue
      )
    case Rare =>
      baseAction.copy(
        sound = epic,
        minimapIcon = (Blue, Circle),
        beam = (Blue, true)
      )
    case _ =>
      baseAction.copy(
        sound = epic,
        beam = (Blue, true)
      )
  }
}
