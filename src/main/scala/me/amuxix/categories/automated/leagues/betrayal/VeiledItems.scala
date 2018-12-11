package me.amuxix.categories.automated.leagues.betrayal
import me.amuxix._
import me.amuxix.actions.Color.goodYellow
import me.amuxix.actions.Sound.{veskara1, veskara2}
import me.amuxix.actions.{Action, Hexagon, White}
import me.amuxix.categories.automated.leagues.LeagueAutomatedCategory
import me.amuxix.conditions.Condition

object VeiledItems extends LeagueAutomatedCategory {
  override val condition: Condition = Condition(explicitMod = "Veil", identified = true)

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysShow =>
      Action(
        minimapIcon = (White, Hexagon),
        sound = veskara2
      )
    case Epic =>
      Action(
        minimapIcon = (White, Hexagon),
        beam = (White, true),
        sound = veskara2,
        size = 45,
      )
    case _ =>
      Action(
        minimapIcon = (White, Hexagon),
        beam = (White, true),
        sound = veskara1,
        size = 45,
        borderColor = goodYellow,
        textColor = goodYellow
      )
  }
}
