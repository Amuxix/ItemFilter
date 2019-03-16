package me.amuxix.categories.single
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object BreachRings extends SingleConditionAndActionCategory {

  override protected val condition: Condition = Condition(base = "Breach Ring")
  override protected val action: Action = Action(size = 45, borderColor = Color.darkRed, backgroundColor = Color.black, textColor = Color.purple)
}
