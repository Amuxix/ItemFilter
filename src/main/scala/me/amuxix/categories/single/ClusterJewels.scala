package me.amuxix.categories.single

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object ClusterJewels extends SingleConditionAndActionCategory {
  override protected lazy val condition: Condition = Condition(base = Seq("Cluster Jewel"))
  override protected val action: Action =
    Action(size = 45, backgroundColor = Color.purple)
}
