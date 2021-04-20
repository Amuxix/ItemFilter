package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions.Condition
import cats.syntax.show._

object Block {
  def apply(condition: Condition, action: Action): Block = new Block(condition, action)
}

case class Block(condition: Condition, action: Action, rarity: FilterRarity = Undetermined) extends Mergeable[Block] {

  def show(filterLevel: FilterLevel): Boolean = rarity >= filterLevel.cutoffRarity

  def write(filterLevel: FilterLevel, useContinue: Boolean = false): String = {
    val showText = if (show(filterLevel)) "Show" else "Hide"
    val disableDropSound = "\n  DisableDropSound"
    val continue = Option.when(useContinue)("\n  Continue")
    show"$showText$condition$action$disableDropSound$continue\n"
  }

  lazy val hidden: Block = Block(condition, action.copy(sound = None, minimapIcon = None, beam = None), rarity = AlwaysHide)

  override def canMerge(other: Block): Boolean = action == other.action && rarity == other.rarity && (condition canMerge other.condition)

  override def merge(other: Block): Block = Block(condition merge other.condition, action, rarity)
}
