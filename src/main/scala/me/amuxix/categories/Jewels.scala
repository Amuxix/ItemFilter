package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.conditions.{Condition, Rare}
import me.amuxix.{Block, FilterLevel}

class Jewels extends Category {
  val rare = Block(Condition(`class`= "Jewel", rarity = Rare), Action(size = 40))
  val rest = Block(Condition(`class`= "Jewel"), Action(size = 35))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(rare, rest)
}
