package me.amuxix.categories.automated
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Abyss extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(base = Seq("Eye Jewel", "Stygian Vise"))
  override protected val action: Action = Action(size = 45, borderColor = Color.slimeGreen)
}
