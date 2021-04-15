package me.amuxix.categories.semiautomated.recipes

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenericItem, Value}
import me.amuxix.providers.Provider

abstract class Sized extends SemiAutomatedCategory { outer =>
  def condition: Condition
  def chaosValue(provider: Provider): Option[Double]

  def generateGenericItem(height: Int, width: Int): GenericItem = new GenericItem with Value {
    override def chaosValuePerSlot(provider: Provider): Option[Double] = chaosValue(provider).map(_ / (width * height))
    override lazy val condition: Condition = outer.condition.copy(height = height, width = width)
  }

  override protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.fromListUnsafe((for {
    height <- 2 to 4
    width <- 1 to 2
  } yield generateGenericItem(height, width)).toList)

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
