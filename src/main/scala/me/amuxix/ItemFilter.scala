package me.amuxix

import me.amuxix.actions.{Action, Color}
import me.amuxix.conditions.Condition

object ItemFilter extends ImplicitConversions {
  val yellow = Color(255, 255, 0)
  val white = Color(255, 255, 255)

  def main(args: Array[String]): Unit = {
    val condition = Condition(
      base = "One Handed Sword",
      `class` = "Batata",
      height = 25,
    )
    val block = Block(condition, Action(size = 40), show = true)
    println(block.write)
  }

  /*/**
    * Write a block for item filter
    * @param show Is this a block to show items or to hide?
    * @param conditions Conditions this block uses
    * @param actions Actions this block performs
    * @return
    */
  def block(show: Boolean, conditions: Seq[BaseCondition], actions: Seq[BaseAction]): String = {
    if (show) {
      "Show"
    } else {
      "Hide"
    } + "\n" + conditions.map(_.toString + "\n") + actions.map(_.toString + "\n")
  }

  def block(conditions: Seq[BaseCondition], actions: Seq[BaseAction]): String = block(show = true, conditions, actions)

  def separator(text: String): String = {
    val equals = "=" * ((117 - text.length) / 2)
    s"$equals $text $equals"
  }
  private val itemFilter = {
    separator("Fishing Rods")
    block(Seq[BaseCondition](FishingRods), Seq(FontSize(45), Sound(5, 300), BorderColor(yellow), TextColor(yellow)))
  }*/
}
