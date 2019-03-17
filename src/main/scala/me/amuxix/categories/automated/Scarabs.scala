package me.amuxix.categories.automated
import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Color.{delveOrange, scarabBlue}
import me.amuxix.actions.Sound.{epic, myths}
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.MapFragments
import me.amuxix.items.Item

import scala.concurrent.Future

object Scarabs extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[Item]] = MapFragments.scarabs
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
