package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Map

class MapsTable(tag: Tag) extends Table[Map](tag, "maps") with NamedTable[Map] {
  def tier = column[Int]("tier")

  override def * = (
    name,
    tier,
  ) <> ((Map.apply _).tupled, Map.unapply)
}
object Maps extends BasicOperations[Map, MapsTable](new MapsTable(_))