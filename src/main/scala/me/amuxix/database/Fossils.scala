package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Fossil

class FossilsTable(tag: Tag) extends Table[Fossil](tag, "fossils") with NamedTable[Fossil] {
  override def * = name <> (Fossil.apply, Fossil.unapply)
}

object Fossils extends BasicOperations[Fossil, FossilsTable](new FossilsTable(_))
