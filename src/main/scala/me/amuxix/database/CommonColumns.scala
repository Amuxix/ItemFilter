package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._

import java.sql.Timestamp

trait CommonColumns[T] extends Table[T] {
  def name = column[String]("name")
  def dropEnabled = column[Boolean]("drop_enabled", O.Default(true))
  def updatedAt = column[Timestamp]("updated_at")
}
