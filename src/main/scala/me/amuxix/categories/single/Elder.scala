package me.amuxix.categories.single
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Elder extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(elderItem = true)
}
