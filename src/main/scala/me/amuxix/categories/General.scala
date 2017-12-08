package me.amuxix.categories

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

class General extends Category {
  val quests = Block(
    Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul")),
    Action(size = 45)
  )

  val sixLinks = Block(
    Condition(sockets = 6),
    Action(size = 45, sound = Sound.sixLinks, border = Color.red)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(quests, sixLinks)
}
