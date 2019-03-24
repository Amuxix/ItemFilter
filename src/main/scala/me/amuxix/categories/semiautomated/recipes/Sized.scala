package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenericItem, Value}

import scala.concurrent.Future

abstract class Sized extends SemiAutomatedCategory { outer =>
  def condition: Condition
  def chaosValue: OptionT[Future, Double]

  def generateGenericItem(height: Int, width: Int): Future[GenericItem] =
    Future.successful {
      new GenericItem with Value {
        override lazy val chaosValuePerSlot: OptionT[Future, Double] = chaosValue.map(_ / (width * height))
        override lazy val condition: Future[Condition] = Future.successful(outer.condition.copy(height = height, width = width))
      }
    }

  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    NonEmptyList.fromListUnsafe(
      (for {
        height <- 2 to 4
        width <- 1 to 2
      } yield generateGenericItem(height, width)).toList
    ).sequence

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
