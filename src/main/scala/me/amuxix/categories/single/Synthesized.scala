package me.amuxix.categories.single
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Synthesized extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(synthesisedItem = true)
}
