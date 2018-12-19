package me.amuxix.database

import java.sql.Timestamp

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.database.model.Item

object Items {
  class PriceTable(tag: Tag) extends Table[Item](tag, "price") {
    def name = column[String]("name")
    def height = column[Int]("height")
    def weight = column[Int]("weight")
    def `class` = column[String]("class")
    def dropLevel = column[Int]("drop_level")
    def updatedAt = column[Timestamp]("updated_at")

    override def * = (
      name,
      height,
      weight,
      `class`,
      dropLevel.?,
    ) <> (Item.tupled, Item.unapply)
  }
}
