package me.amuxix.categories

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object General extends Category {
  val quests = Block(
    Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")),
    Action(size = 45)
  )

  val sixLinks = Block(
    Condition(sockets = 6),
    Action(size = 45, sound = Sound.sixLinks, borderColor = Color.red)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(quests, sixLinks)
}
