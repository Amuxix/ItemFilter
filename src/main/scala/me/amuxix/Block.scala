package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions.Condition
import cats.syntax.show._
import me.amuxix.syntax.mergeable._
import me.amuxix.instances.option._

object Block {
  def apply(condition: Condition, action: Action): Block = new Block(condition, action)

  implicit val mergeable: Mergeable[Block] = new Mergeable[Block] {
    override def canMerge(one: Block, other: Block): Boolean = one.action == other.action && one.rarity == other.rarity && (one.condition canMerge other.condition)

    override def merge(one: Block, other: Block): Block = Block(one.condition merge other.condition, one.action, one.rarity)
  }
}

case class Block(condition: Condition, action: Action, rarity: FilterRarity = Undetermined) {

  def show(filterLevel: FilterLevel): Boolean = rarity >= filterLevel.cutoffRarity

  def write(filterLevel: FilterLevel, useContinue: Boolean = false): String = {
    val showText = if (show(filterLevel)) "Show" else "Hide"
    val disableDropSound = "\n  DisableDropSound"
    val continue = Option.when(useContinue)("\n  Continue")
    show"$showText$condition$action$disableDropSound$continue\n"
  }

  lazy val hidden: Block = Block(condition, action.copy(sound = None, minimapIcon = None, beam = None), rarity = AlwaysHide)
}
