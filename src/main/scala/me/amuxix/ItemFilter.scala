package me.amuxix

import me.amuxix.ImplicitConversions._
import me.amuxix.actions._
import me.amuxix.conditions.Condition

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemFilter {
  val > = ">"
  val < = "<"
  val >= = ">="
  val <= = "<="

  val yellow = Color(255, 255, 0)
  val white = Color(255, 255, 255)

  def main(args: Array[String]): Unit = {
    println(Block(Condition(base = ImplicitConversions.string2OptionBaseType("One Handed Sword")), Action(size = 40), show = true).write)
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
