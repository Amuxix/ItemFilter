package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

import scala.concurrent.Future

abstract class Sized extends SemiAutomatedCategory { outer =>
  def condition: Condition
  def chaosValue: OptionT[Future, Double]

  def generateGenericItem(height: Int, width: Int): Future[GenItem] =
    Future.successful {
      new GenItem {
        override lazy val chaosValuePerSlot: OptionT[Future, Double] = chaosValue.map(_ / (width * height))
        override lazy val condition: Future[Condition] = Future.successful(outer.condition.copy(height = height, width = width))
      }
    }

  override protected val categoryItems: Future[NonEmptyList[GenItem]] =
    NonEmptyList.fromListUnsafe(List(
      generateGenericItem(3, 1),
      generateGenericItem(2, 2),
      generateGenericItem(4, 1),
      generateGenericItem(3, 2),
      generateGenericItem(4, 2),
    )).sequence

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
