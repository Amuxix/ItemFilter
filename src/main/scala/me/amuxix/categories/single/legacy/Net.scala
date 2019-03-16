package me.amuxix.categories.single.legacy
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object Net extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(base = "Net")
  override protected val action: Action = Action(size = 45, borderColor = Color.nets.darken, textColor = Color.nets.darken.darken, backgroundColor = Color.goodYellow.lighten)
}
