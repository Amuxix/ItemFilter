package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.UniqueItem

class UniquesTable(tag: Tag) extends Table[UniqueItem](tag, "uniques") with CommonColumns[UniqueItem] {
  def base = column[String]("base")

  override def * = (
    name,
    base,
    dropEnabled,
  ).mapTo[UniqueItem]
}

object Uniques extends BasicOperations[UniqueItem, UniquesTable](new UniquesTable(_))