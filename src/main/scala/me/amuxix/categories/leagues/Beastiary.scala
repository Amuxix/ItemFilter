package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel, Normal, Reduced}

object Beastiary extends Category {
  val ropeNet = Block(
    Condition(base = "Rope Net", `class` = "Currency"),
    Action(size = 45, textColor = Color.nets, backgroundColor = Color.black)
  )

  val ironNet = Block(
    Condition(base = "Iron Net", `class` = "Currency"),
    Action(size = 45, borderColor = Color.nets, textColor = Color.nets, backgroundColor = Color.black)
  )

  val steelNet = Block(
    Condition(base = "Steel Net", `class` = "Currency"),
    Action(size = 45, borderColor = Color.nets.darken, textColor = Color.nets.darken.darken, backgroundColor = Color.goodYellow.lighten)
  )

  val thaumaturgicalNet = Block(
    Condition(base = "Thaumaturgical Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets.louder, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.nets.lighten)
  )

  val necromancyNet = Block(
    Condition(base = "Necromancy Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets.louder, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.nets.lighten)
  )

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(ropeNet, ironNet, steelNet).map(_.hidden) ++ Seq(thaumaturgicalNet, necromancyNet)
    case Normal  => Seq(ropeNet, ironNet).map(_.hidden) ++ Seq(steelNet, thaumaturgicalNet, necromancyNet)
    case _       => Seq(ropeNet, ironNet, steelNet, thaumaturgicalNet, necromancyNet)
  }
}
