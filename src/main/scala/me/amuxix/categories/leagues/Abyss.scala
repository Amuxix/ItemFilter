package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Abyss extends Category {
  val abyss = Block(Condition(base = Seq("Eye Jewel", "Stygian Vise")), Action(size = 45, borderColor = Color.slimeGreen))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(abyss)
}
