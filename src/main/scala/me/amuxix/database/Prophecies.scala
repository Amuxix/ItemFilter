package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.Prophecy

class PropheciesTable(tag: Tag) extends Table[Prophecy](tag, "prophecies") with CommonColumns[Prophecy] {
  override def * = (
    name,
    dropEnabled,
  ).mapTo[Prophecy]
}

object Prophecies extends BasicOperations[Prophecy, PropheciesTable](new PropheciesTable(_))
