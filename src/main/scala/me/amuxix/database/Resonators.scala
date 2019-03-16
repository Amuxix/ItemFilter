package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Resonator

import scala.concurrent.Future

class ResonatorsTable(tag: Tag) extends Table[Resonator](tag, "resonators") with NamedTable[Resonator] {
  def reforges = column[Boolean]("reforges")
  override def * = (
    name,
    reforges,
  ) <> ((Resonator.apply _).tupled, Resonator.unapply)
}

object Resonators extends BasicOperations[Resonator, ResonatorsTable](new ResonatorsTable(_)) {
  def chaotic: Future[Seq[Resonator]] = db.run(filter(_.reforges).result)

  def alchemical: Future[Seq[Resonator]] = db.run(filter(_.reforges === false).result)
}
