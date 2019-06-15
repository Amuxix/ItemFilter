package me.amuxix.categories.automated.currency
import cats.data.NonEmptyList
import me.amuxix.{Common, Priced, Uncommon}
import me.amuxix.actions.{Action, Blue, Circle, Triangle}
import me.amuxix.actions.Color.{delveBlue, legacyBlue}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Resonators
import me.amuxix.items.Item

import scala.concurrent.Future

object AlchemicalResonators extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[Item]] =
    Resonators.alchemical
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
        borderColor = legacyBlue,
        textColor = legacyBlue.darken,
        backgroundColor = delveBlue,
        minimapIcon = (Blue, Circle),
      )
    case _ =>
      Action(
        size = 40,
        borderColor = legacyBlue,
        textColor = legacyBlue.darken,
        backgroundColor = delveBlue,
        minimapIcon = (Blue, Triangle),
        beam = Blue,
      )
  }
}
