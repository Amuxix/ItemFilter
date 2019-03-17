package me.amuxix.database

import java.sql.Timestamp

import me.amuxix.database.PostgresProfile.api._

trait CommonColumns[T] extends Table[T] {
  def name = column[String]("name")
  def dropEnabled = column[Boolean]("drop_enabled")
  def updatedAt = column[Timestamp]("updated_at")
}
