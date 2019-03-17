package me.amuxix.categories.single
import me.amuxix.actions.Action
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Atlas extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(base = Seq("Steel Ring", "Opal Ring", "Crystal Belt"))
  override protected val action: Action = Action(size = 45)
}
