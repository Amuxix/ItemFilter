package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories2.Category
import me.amuxix.conditions.{Condition, Rare}

object Jewels extends Category {
  val rare = Block(Condition(`class` = "Jewel", rarity = Rare), Action(size = 40))
  val rest = Block(Condition(`class` = "Jewel"), Action(size = 35))

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(rare, rest.hidden)
    case _       => Seq(rare, rest)
  }
}
