package me.amuxix.categories

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.AlwaysShow

trait SingleConditionAndActionCategory extends SemiAutomatedCategory { outer =>
  protected val condition: Condition
  protected val action: Action = Action()

  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    IO(NonEmptyList.one(GenericItem(AlwaysShow, outer.condition)))

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    action
  }
}
