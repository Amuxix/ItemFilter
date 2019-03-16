package me.amuxix.categories.automated.currency
import me.amuxix.actions.Color.{delveBlue, legacyBlue}
import me.amuxix.actions.{Action, Blue, Circle, Triangle}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Resonators
import me.amuxix.items.Item
import me.amuxix.{Common, FilterRarity, Priced, Uncommon}

import scala.concurrent.Future

object AlchemicalResonators extends AutomatedCategory {
  override protected val items: Future[Seq[Item]] = Resonators.chaotic
  override protected def action: FilterRarity with Priced => Action = {
    case Common =>
      Action(
        size = 35,
        textColor = legacyBlue,
        backgroundColor = delveBlue,
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