package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions.Condition

object Block {

  def apply(condition: Condition, action: Action): Block =
    new Block(condition, action)
}

case class Block(condition: Condition, action: Action, rarity: FilterRarity = Undetermined) extends Mergeable[Block] {

  def show(filterLevel: FilterLevel): Boolean =
    rarity >= filterLevel.cutoffRarity

  def write(filterLevel: FilterLevel): String = {
    val showText = if (show(filterLevel)) "Show" else "Hide"
    val actionsAndConditions = ((condition.conditions ++ action.actions).flatMap(_.write) :+ "DisableDropSound").mkString("\n  ", "\n  ", "\n")
    showText + actionsAndConditions
  }

  def hidden: Block = Block(
    condition,
    action.copy(
      sound = None,
      minimapIcon = None,
      beam = None
    ),
    rarity = AlwaysHide
  )

  override def canMerge(other: Block): Boolean =
    action == other.action && rarity == other.rarity && (condition canMerge other.condition)

  override def merge(other: Block): Block =
    Block(condition merge other.condition, action, rarity)
}
