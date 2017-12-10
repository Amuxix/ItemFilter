package me.amuxix.categories.leagues

import me.amuxix.actions.Action
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Atlas extends Category {
 val bases = Block(Condition(base = Seq("Steel Ring", "Opal Ring", "Crystal Belt")), Action(size = 45))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(bases)
}
