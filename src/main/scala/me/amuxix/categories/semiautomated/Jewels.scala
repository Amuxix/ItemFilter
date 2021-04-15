package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{FilterRarity, Leveling, Uncommon}
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Jewels extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.of(
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Uncommon
      override lazy val condition: Condition = Condition(`class` = "Jewel", rarity = GameRare)
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Leveling
      override lazy val condition: Condition = Condition(`class` = "Jewel")
    },
  )

  override protected def actionForRarity: FilterRarity => Action = {
    case Uncommon => Action(size = 40)
    case _        => Action(size = 35)
  }
}
