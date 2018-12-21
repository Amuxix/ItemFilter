package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.MapFragment

import scala.concurrent.Future

object MapFragments extends BasicOperations[MapFragment] {
  type Table = MapFragmentsTable
  class MapFragmentsTable(tag: Tag) extends NamedTable[MapFragment](tag, "map_fragments") {
    def fragmentType = column[String]("fragment_type")

    override def * = (
      name,
      fragmentType,
      ) <> ((MapFragment.apply _).tupled, MapFragment.unapply)
  }

  def scarabs: Future[Seq[MapFragment]] =
    db.run(query.filter(_.fragmentType === "Scarab").result)

  def nonScarabs: Future[Seq[MapFragment]] =
    db.run(query.filter(_.fragmentType =!= "Scarab").result)
}
