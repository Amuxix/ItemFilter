package me.amuxix.categories.automated.currency

import me.amuxix.actions.Color.{black, darkRed, white}
import me.amuxix.actions._
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.database.MapFragments
import me.amuxix.items.GenItem
import me.amuxix.{Epic, FilterRarity, Mythic, Rare}

import scala.concurrent.Future

object Fragment extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = MapFragments.nonScarabs

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Mythic =>
      Action(
        borderColor = darkRed,
        backgroundColor = white,
        textColor = darkRed,
        minimapIcon = (Red, Triangle),
        beam = Red,
      )
    case Epic =>
      Action(
        borderColor = darkRed,
        textColor = darkRed,
        minimapIcon = (Yellow, Triangle),
        beam = Yellow,
      )
    case Rare =>
      Action(
        borderColor = black,
        textColor = darkRed,
        minimapIcon = (White, Triangle),
        beam = White,
      )
    case _ =>
      Action(
        backgroundColor = white,
        textColor = black,
      )
  }
}
