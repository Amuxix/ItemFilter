package me.amuxix.categories.automated.mapfragments

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{delveOrange, scarabBlue}
import me.amuxix.actions.Sound.{epic, myths}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.{MapFragments => DBMapFragments}
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced.{Epic, Mythic, Rare}
import me.amuxix.actions.Shape.Circle
import me.amuxix.FilterRarity.Priced
import me.amuxix.actions.EffectColor.Blue

object Scarabs extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] =
    DBMapFragments.scarabs
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
