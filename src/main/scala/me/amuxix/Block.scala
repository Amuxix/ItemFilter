package me.amuxix

import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

object Block {
  def apply(condition: Condition, action: Action): Block = new Block(condition, action, true)
}

case class Block(condition: Condition, action: Action, show: Boolean) {
  val write: String = {
    val showText = if (show) "Show" else "Hide"
    val actionsAndConditions = (condition.conditions ++ action.actions).flatMap(_.write).mkString("\n  ", "\n  ", "\n")
    showText + actionsAndConditions
  }

  def hidden: Block = Block(condition, action, show = false)
}