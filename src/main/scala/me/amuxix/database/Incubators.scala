package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.Incubator

class IncubatorsTable(tag: Tag) extends Table[Incubator](tag, "incubators") with CommonColumns[Incubator] {
  override def * =
    (
      name,
      dropEnabled,
    ).mapTo[Incubator]
}

object Incubators extends BasicOperations[Incubator, IncubatorsTable](new IncubatorsTable(_))
