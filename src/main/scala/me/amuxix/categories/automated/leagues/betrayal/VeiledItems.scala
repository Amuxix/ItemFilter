package me.amuxix.categories.automated.leagues.betrayal
import me.amuxix._
import me.amuxix.actions.Color.goodYellow
import me.amuxix.actions.Sound.{veskara1, veskara2}
import me.amuxix.actions.{Action, Hexagon, White}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.items.bases.Base.{allEquipment, bestItems}

object VeiledItems extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = bestItems.map(base =>
    new GenItem(Mythic) { override protected def condition: Condition = base.rare.copy(explicitMod = "Veil", identified = true) },
  ) ++ allEquipment.flatMap(base =>
    Seq(
      new GenItem(Epic) { override protected def condition: Condition = base.conditionsOfBestRaresForZoneLevel.copy(explicitMod = "Veil", identified = true) },
      new GenItem(Rare) { override protected def condition: Condition = base.conditionsOfGoodRaresForZoneLevel.copy(explicitMod = "Veil", identified = true) },
    )
  ) ++ Seq(
    new GenItem(AlwaysShow) { override protected def condition: Condition = Condition(explicitMod = "Veil", identified = true) }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysShow =>
      Action(
        minimapIcon = (White, Hexagon),
        sound = veskara2
      )
    case Mythic =>
      Action(
        minimapIcon = (White, Hexagon),
        beam = (White, true),
        sound = veskara1,
        size = 45,
        borderColor = goodYellow,
        textColor = goodYellow
      )
    case _ => Action(
      minimapIcon = (White, Hexagon),
      beam = (White, true),
      sound = veskara2,
      size = 45,
    )
  }
}
