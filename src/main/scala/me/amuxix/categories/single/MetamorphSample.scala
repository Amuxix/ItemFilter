package me.amuxix.categories.single

import me.amuxix.actions.{Action, Green, Star}
import me.amuxix.actions.Color.{black, legacyBlue}
import me.amuxix.actions.Sound.epic
import me.amuxix.categories.SingleConditionAndActionCategory
import me.amuxix.conditions.Condition

object MetamorphSample extends SingleConditionAndActionCategory {
  override protected val condition: Condition = Condition(`class` = "Metamorph Sample")
  override protected val action: Action =
    Action(
      size = 45,
      sound = epic,
      backgroundColor = legacyBlue,
      textColor = black,
      borderColor = black,
      minimapIcon = (Green, Star),
      beam = Green,
    )
}
