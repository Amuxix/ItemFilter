package me.amuxix.categories

import me.amuxix
import me.amuxix.FilterLevel
import me.amuxix.conditions.Condition

object Flasks extends Category {
  val all = amuxix.Block(Condition(`class` = "Flasks"))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(all)
}
