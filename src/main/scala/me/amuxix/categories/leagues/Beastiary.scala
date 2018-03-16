package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Beastiary extends Category {
  val beastiaryOrbs = Block(
    Condition(base = "Bestiary Orb", `class` = "Currency"),
    Action(size = 45, sound = Sound.rare, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.goodYellow.lighten)
  )

  val ropeNet = Block(
    Condition(base = "Rope Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets, textColor = Color.nets, backgroundColor = Color.black)
  )

  val ironNet = Block(
    Condition(base = "Iron Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets, borderColor = Color.nets, textColor = Color.nets, backgroundColor = Color.black)
  )

  val steelNet = Block(
    Condition(base = "Steel Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets, borderColor = Color.nets.darken, textColor = Color.nets.darken.darken, backgroundColor = Color.goodYellow.lighten)
  )

  val thaumaturgicalNet = Block(
    Condition(base = "Thaumaturgical Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets.louder, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.nets.lighten)
  )

  val necromancyNet = Block(
    Condition(base = "Necromancy Net", `class` = "Currency"),
    Action(size = 45, sound = Sound.nets.louder, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.nets.lighten)
  )

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = Seq(beastiaryOrbs, ropeNet, ironNet, steelNet, thaumaturgicalNet, necromancyNet)
}
