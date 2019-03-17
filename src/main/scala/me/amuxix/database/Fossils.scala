package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Fossil

class FossilsTable(tag: Tag) extends Table[Fossil](tag, "fossils") with CommonColumns[Fossil] {
  override def * = (
    name,
    dropEnabled,
  ).mapTo[Fossil]
}

object Fossils extends BasicOperations[Fossil, FossilsTable](new FossilsTable(_))
