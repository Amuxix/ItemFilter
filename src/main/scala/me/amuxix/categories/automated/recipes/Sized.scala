package me.amuxix.categories.automated.recipes
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.{Condition, Height, Width}
import me.amuxix.items.GenItem

abstract class Sized extends AutomatedCategory { outer =>
  def condition: Condition
  def chaosValue: Option[Double]

  def generateGenericItem(height: Height, width: Width): GenItem =
    new GenItem {
      override lazy val chaosValuePerSlot: Option[Double] = chaosValue.map(_ / (width.i * height.i))
      override protected lazy val condition: Condition = outer.condition.copy(height = Some(height), width = Some(width))
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
