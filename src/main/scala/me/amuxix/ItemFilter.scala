package me.amuxix

import me.amuxix.actions._

/**
  * Created by Amuxix on 03/03/2017.
  */
class ItemFilter {
  val > = ">"
  val < = "<"
  val >= = ">="
  val <= = "<="

  val yellow = Color(255, 255, 0)
  val white = Color(255, 255, 255)

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
