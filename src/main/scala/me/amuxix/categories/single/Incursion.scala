package me.amuxix.categories.single

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Incursion extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(`class` = "Incursion Item")
  override protected val action: Action = Action(size = 45, backgroundColor = Color.black, textColor = Color.incursionRed, borderColor = Color.incursionGreen, sound = Sound.incursion)
}
