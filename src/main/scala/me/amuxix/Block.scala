package me.amuxix

import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

case class Block(condition: Condition, action: Action) {
  def write(filterLevel: FilterLevel): String = {
    (condition.conditions ++ action.actions).map { t =>
      t.write(Default.getDefault(t))
    }.filter(_.isDefined).mkString("\n")
  }
}
