package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.UniqueItem

class UniquesTable(tag: Tag) extends Table[UniqueItem](tag, "uniques") with CommonColumns[UniqueItem] {
  def base = column[String]("base")
  def league = column[String]("league")

  override def * =
    (
      name,
      base,
      dropEnabled,
      league.?,
    ).mapTo[UniqueItem]
}

object Uniques extends BasicOperations[UniqueItem, UniquesTable](new UniquesTable(_))
