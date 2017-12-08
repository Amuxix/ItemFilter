package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

class Breach extends Category {
  val action = Action(size = 45, border = Color.darkRed, background = Color.black, text = Color.purple)

  val blessing = Condition(base = "Blessing of")
  val breachRing = Condition(base = "Breach of")
  val splinter = Condition(base = "Splinter of")

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = Seq(blessing, breachRing, splinter).map(Block(_, action))
}
