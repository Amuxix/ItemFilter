package me.amuxix.categories

import me.amuxix.ImplicitConversions._
import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel, ImplicitConversions}

class Myths extends Category {
  val bigAction = Action(size = 45, sound = Sound.myths, border = Color.red, background = Color.white, text = Color.red)

  val albinoRhoaFeather = Condition(base = ImplicitConversions.string2OptionBaseType("Albino Rhoa Feather"))
  val fishingRod = Condition(`class` = ImplicitConversions.String2OptionItemClass("Fishing Rod"))
  val sixLinks = Condition(linkedSockets = 6)
  val fiveLinks = Condition(linkedSockets = 5)

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case _ => Seq(albinoRhoaFeather, fishingRod, sixLinks, fiveLinks).map(Block(_, bigAction))
  }
}
