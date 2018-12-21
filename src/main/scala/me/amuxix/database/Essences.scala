package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.Essence

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Essences extends BasicOperations[Essence] {
  implicit def essenceColumnType = MappedColumnType.base[Essence, String](
    _.name,
    name => Await.result(getByName(name), Duration.Inf)
  )
  class EssencesTable(tag: Tag) extends NamedTable[Essence](tag, "essences") {
    def upgradesTo = column[Essence]("upgrades_to")

    override def * = (
      name,
      upgradesTo.?,
    ) <> ((Essence.apply _).tupled, Essence.unapply)
  }
}
