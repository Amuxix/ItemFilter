package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.MapFragment

import scala.concurrent.Future

class MapFragmentsTable(tag: Tag) extends Table[MapFragment](tag, "map_fragments") with NamedTable[MapFragment] {
  def fragmentType = column[String]("fragment_type")

  override def * = (
    name,
    fragmentType,
  ) <> ((MapFragment.apply _).tupled, MapFragment.unapply)
}
object MapFragments extends BasicOperations[MapFragment, MapFragmentsTable](new MapFragmentsTable(_)) {

  def scarabs: Future[Seq[MapFragment]] =
    db.run(filter(_.fragmentType === "Scarab").result)

  def nonScarabs: Future[Seq[MapFragment]] =
    db.run(filter(_.fragmentType =!= "Scarab").result)
}
