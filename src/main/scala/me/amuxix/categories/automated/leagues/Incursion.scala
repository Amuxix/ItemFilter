package me.amuxix.categories.automated.leagues
import me.amuxix._
import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition

object Incursion extends LeagueAutomatedCategory {
  override val condition: Condition = Condition(`class` = "Incursion Item")

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysShow =>
      Action(
        backgroundColor = Color.black,
        textColor = Color.incursionRed,
        borderColor = Color.incursionGreen,
        sound = Sound.incursion
      )
    case Rare =>
      Action(
        size = 40,
        backgroundColor = Color.black,
        textColor = Color.incursionRed,
        borderColor = Color.incursionGreen,
        sound = Sound.incursion
      )
    case _ =>
      Action(
        size = 45,
        backgroundColor = Color.black,
        textColor = Color.incursionRed,
        borderColor = Color.incursionGreen,
        sound = Sound.incursion
      )
  }
}
