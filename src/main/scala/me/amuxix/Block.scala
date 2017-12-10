package me.amuxix

import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

object Block {
  def apply(condition: Condition, action: Action): Block = new Block(condition, action, true)
  def apply(condition: Condition): Block = new Block(condition, Action(), true)
}

case class Block(condition: Condition, action: Action, show: Boolean) extends Mergeable[Block] {
  val write: String = {
    val showText = if (show) "Show" else "Hide"
    val actionsAndConditions = (condition.conditions ++ action.actions).flatMap(_.write).mkString("\n  ", "\n  ", "\n")
    showText + actionsAndConditions
  }

  def hidden: Block = Block(condition, action, show = false)

  override def canMerge(other: Block): Boolean = {
    (condition canMerge other.condition) && action == other.action && show == other.show
  }

  override def merge(other: Block) = Block(condition merge other.condition, action, show)
}