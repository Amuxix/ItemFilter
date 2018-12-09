package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.GenItem
import me.amuxix.{FilterRarity, Rare, Uncommon}

object Jewels extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem(Uncommon) { override protected def condition: Condition = Condition(`class` = "Jewel", rarity = GameRare) },
    new GenItem(Rare) { override protected def condition: Condition = Condition(`class` = "Jewel") },
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Rare =>
      Action(size = 40)
    case Uncommon =>
      Action(size = 35)
  }
}
