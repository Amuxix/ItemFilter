package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Talisman extends Category {
  val talismans = Block(Condition(base = "Talisman"), Action(borderColor = Color.pink))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(talismans)
}
