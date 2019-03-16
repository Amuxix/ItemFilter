package me.amuxix.categories.semiautomated.recipes
import me.amuxix.ItemFilter.ec
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

import scala.concurrent.Future

abstract class Sized extends SemiAutomatedCategory { outer =>
  def condition: Condition
  def chaosValue: Future[Option[Double]]

  def generateGenericItem(height: Int, width: Int): Future[GenItem] =
    chaosValue.map { value =>
      new GenItem {
        override lazy val chaosValuePerSlot: Option[Double] = value.map(_ / (width * height))
        override lazy val condition: Condition = outer.condition.copy(height = height, width = width)
      }
    }

  override protected val categoryItems: Future[Seq[GenItem]] = Future.sequence(Seq(
    generateGenericItem(3, 1),
    generateGenericItem(2, 2),
    generateGenericItem(4, 1),
    generateGenericItem(3, 2),
    generateGenericItem(4, 2),
  ))

  override protected def actionForRarity: FilterRarity => Action = { _ => Action() }
}
