package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

class Legacy extends Category {
  val leaguestones = Block(Condition(`class` = "Leaguestone"), Action(size = 45, text = Color.black, background = Color.legacyBlue))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(leaguestones)
}
