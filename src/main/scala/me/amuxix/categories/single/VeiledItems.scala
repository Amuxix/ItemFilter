package me.amuxix.categories.single
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object VeiledItems extends SingleConditionAndActionCategory {
  override protected val condition: Condition =
    Condition(explicitMod = "Veil", identified = true)
}
