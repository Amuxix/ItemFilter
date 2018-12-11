package me.amuxix.categories.automated.recipes
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

abstract class Sized extends AutomatedCategory { outer =>
  def condition: Condition
  def chaosValue: Option[Double]

  def generateGenericItem(height: Int, width: Int): GenItem =
    new GenItem {
      override lazy val chaosValuePerSlot: Option[Double] = chaosValue.map(_ / (width * height))
      override protected lazy val condition: Condition = outer.condition.copy(height = height, width = width)
    }

  override protected val categoryItems: Seq[GenItem] = Seq(
    generateGenericItem(3, 1),
    generateGenericItem(2, 2),
    generateGenericItem(4, 1),
    generateGenericItem(3, 2),
    generateGenericItem(4, 2),
  )

  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
