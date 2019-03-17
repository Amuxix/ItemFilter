package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.MapFragment

import scala.concurrent.Future

class MapFragmentsTable(tag: Tag) extends Table[MapFragment](tag, "map_fragments") with CommonColumns[MapFragment] {
  def fragmentType = column[String]("fragment_type")

  override def * = (
    name,
    fragmentType,
    dropEnabled,
  ).mapTo[MapFragment]
}
object MapFragments extends BasicOperations[MapFragment, MapFragmentsTable](new MapFragmentsTable(_)) {

  lazy val scarabs: Future[NonEmptyList[MapFragment]] =
    db.run(filter(_.fragmentType === "Scarab").result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  lazy val nonScarabs: Future[NonEmptyList[MapFragment]] =
    db.run(filter(_.fragmentType =!= "Scarab").result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }
}
