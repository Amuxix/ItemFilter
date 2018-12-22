package me.amuxix.database

import java.sql.Timestamp

import me.amuxix.database.PostgresProfile.api._

trait NamedTable[T] extends Table[T] {
  def name = column[String]("name")
  def updatedAt = column[Timestamp]("updated_at")
}
