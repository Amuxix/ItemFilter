package me.amuxix.categories.automated.leagues.betrayal
import me.amuxix._
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.database.MapFragments
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Scarab extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = MapFragments.scarabs
  private val baseAction = Action(
    textColor = delveOrange,
    borderColor = scarabBlue,
  )
  override protected def actionForRarity(rarity:  FilterRarity): Action = rarity match {
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
