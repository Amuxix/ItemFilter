package me.amuxix.categories.automated.currency

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{delveBlue, goodYellow, legacyBlue}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Resonators
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.FilterRarity.Priced.{Common, Uncommon}
import me.amuxix.actions.EffectColor.Blue
import me.amuxix.actions.Shape.{Circle, Triangle}

object ChaoticResonators extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] = Resonators.chaotic
  override protected def action: Priced => Action = {
    case Common =>
      Action(
        size = 35,
        textColor = legacyBlue,
        backgroundColor = delveBlue,
        minimapIcon = (Blue, Circle),
      )
    case Uncommon =>
      Action(
        size = 40,
        borderColor = goodYellow,
        textColor = legacyBlue.darken,
        backgroundColor = delveBlue,
        minimapIcon = (Blue, Circle),
      )
    case _ =>
      Action(
        size = 40,
        borderColor = goodYellow,
        textColor = legacyBlue.darken,
        backgroundColor = delveBlue,
        minimapIcon = (Blue, Triangle),
        beam = Blue,
      )
  }
}
