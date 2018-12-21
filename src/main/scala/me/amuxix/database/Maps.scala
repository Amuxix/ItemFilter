package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Map

object Maps extends BasicOperations[Map] {
  class MapsTable(tag: Tag) extends NamedTable[Map](tag, "maps") {
    def tier = column[Int]("tier")

    override def * = (
      name,
      tier,
    ) <> ((Map.apply _).tupled, Map.unapply)
  }
}