package me.amuxix.categories

import cats.data.NonEmptyList
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{AlwaysShow, FilterRarity}

import scala.concurrent.Future

trait SingleConditionAndActionCategory extends SemiAutomatedCategory { outer =>
  protected val condition: Condition
  protected val action: Action = Action()

  override protected val categoryItems: Future[NonEmptyList[GenItem]] = Future.successful(
    NonEmptyList.one(
      new CategoryItem(AlwaysShow) { override def condition: Condition = outer.condition }
    ))
  override protected def actionForRarity: FilterRarity => Action = { _ =>
    action
  }
}
