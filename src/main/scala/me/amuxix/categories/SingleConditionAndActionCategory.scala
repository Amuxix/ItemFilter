package me.amuxix.categories

import cats.data.NonEmptyList
import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

trait SingleConditionAndActionCategory extends SemiAutomatedCategory { outer =>
  protected val condition: Condition
  protected val action: Action = Action()

  override protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] =
    NonEmptyList.one(
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = AlwaysShow
        override lazy val condition: Condition = outer.condition
      }
    )
  override protected def actionForRarity: FilterRarity => Action = _ => action
}
