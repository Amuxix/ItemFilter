package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Base

object Bases extends BasicOperations[Base] {
  class BasesTable(tag: Tag) extends NamedTable[Base](tag, "bases") {
    def height = column[Int]("height")
    def weight = column[Int]("weight")
    def dropLevel = column[Int]("drop_level")
    def `class` = column[String]("class")

    override def * = (
      name,
      height,
      weight,
      dropLevel,
      `class`,
    ) <> ((Base.apply _).tupled, Base.unapply)
  }
}
