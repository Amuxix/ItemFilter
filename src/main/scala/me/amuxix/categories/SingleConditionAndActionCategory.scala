package me.amuxix.categories

import cats.data.NonEmptyList
import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem

import scala.concurrent.Future

trait SingleConditionAndActionCategory extends SemiAutomatedCategory { outer =>
  protected val condition: Condition
  protected val action: Action = Action()

  override protected val categoryItems: Future[NonEmptyList[GenericItem]] = Future.successful(
    NonEmptyList.one(
      new GenericItem {
        override def rarity: Future[FilterRarity] = Future.successful(AlwaysShow)
        override lazy val condition: Future[Condition] = Future.successful(outer.condition)
      }
    ))
  override protected def actionForRarity: FilterRarity => Action = { _ =>
    action
  }
}
