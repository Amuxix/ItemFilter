package me.amuxix.categories.automated.leagues.betrayal
import me.amuxix._
import me.amuxix.actions.Color.goodYellow
import me.amuxix.actions.Sound.veiledItems
import me.amuxix.actions.{Action, Hexagon, White}
import me.amuxix.categories.automated.leagues.LeagueAutomatedCategory
import me.amuxix.conditions.Condition

object VeiledItems extends LeagueAutomatedCategory {
  override val condition: Condition = Condition(explicitMod = "Veil", identified = true)

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Rare =>
      Action(
        minimapIcon = (White, Hexagon),
        beam = (White, true),
        sound = veiledItems,
        size = 45,
      )
    case Epic =>
      Action(
        minimapIcon = (White, Hexagon),
        beam = (White, true),
        sound = veiledItems,
        size = 45,
        borderColor = goodYellow,
        textColor = goodYellow
      )
    case _ => //AlwaysShow
      Action(
        minimapIcon = (White, Hexagon),
        sound = veiledItems
      )
  }
}
