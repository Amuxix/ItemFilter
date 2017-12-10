package me.amuxix.categories

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Myths extends Category {
  val bigAction = Action(size = 45, sound = Sound.myths, borderColor = Color.red, backgroundColor = Color.white, textColor = Color.red)

  val albinoRhoaFeather = Condition(base = "Albino Rhoa Feather")
  val fishingRod = Condition(`class` = "Fishing Rod")
  val sixLinks = Condition(linkedSockets = 6)
  val fiveLinks = Condition(linkedSockets = 5)

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = Seq(albinoRhoaFeather, fishingRod, sixLinks, fiveLinks).map(Block(_, bigAction))
}
