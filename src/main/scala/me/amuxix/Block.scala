package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions.Condition

object Block {

  def apply(condition: Condition, action: Action): Block = new Block(condition, action)
}

case class Block(condition: Condition, action: Action, rarity: FilterRarity = Undetermined) extends Mergeable[Block] {

  def show(filterLevel: FilterLevel): Boolean = rarity >= filterLevel.cutoffRarity

  def write(filterLevel: FilterLevel, useContinue: Boolean = true): String = {
    val shown = show(filterLevel)
    val showText = if (shown) "Show" else "Hide"

    val block: Seq[String] = (condition.conditions ++ action.actions).flatMap(_.write)
    val actionsAndConditions = ((block :+ "DisableDropSound") ++ Option.when(shown && useContinue)("Continue")).mkString("\n  ", "\n  ", "\n")
    showText + actionsAndConditions
  }

  lazy val hidden: Block = Block(condition, action.copy(sound = None, minimapIcon = None, beam = None), rarity = AlwaysHide)

  override def canMerge(other: Block): Boolean = action == other.action && rarity == other.rarity && (condition canMerge other.condition)

  override def merge(other: Block): Block = Block(condition merge other.condition, action, rarity)
}
