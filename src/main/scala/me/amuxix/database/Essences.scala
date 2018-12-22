package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Essence

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class EssencesTable(tag: Tag) extends Table[Essence](tag, "essences") with NamedTable[Essence] {
  implicit def essenceColumnType = MappedColumnType.base[Essence, String](
    _.name,
    name => Await.result(Essences.getByName(name), Duration.Inf)
  )
  def upgradesTo = column[Essence]("upgrades_to")

  override def * = (
    name,
    upgradesTo.?,
  ) <> ((Essence.apply _).tupled, Essence.unapply)
}
object Essences extends BasicOperations[Essence, EssencesTable](new EssencesTable(_))
