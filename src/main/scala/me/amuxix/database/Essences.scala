package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Essence

class EssencesTable(tag: Tag) extends Table[Essence](tag, "essences") with NamedTable[Essence] {
  def upgradesTo = column[String]("upgrades_to")

  override def * = (
    name,
    upgradesTo.?,
  ) <> ((Essence.apply _).tupled, Essence.unapply)
}
object Essences extends BasicOperations[Essence, EssencesTable](new EssencesTable(_))
