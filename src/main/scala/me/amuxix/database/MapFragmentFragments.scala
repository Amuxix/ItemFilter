package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.MapFragment
import me.amuxix.database.types.MapFragment.MapFragmentType
import me.amuxix.items.MapFragmentFragment

import scala.concurrent.Future

class MapFragmentFragmentsTable(tag: Tag) extends Table[MapFragmentFragment](tag, "map_fragment_fragments") with CommonColumns[MapFragmentFragment] {
  def stackSize = column[Int]("stack_size")
  def fragmentOf = column[String]("fragment_of")
  def fragmentType = column[MapFragmentType]("fragment_type")

  override def * =
    (
      name,
      stackSize,
      fragmentOf,
      fragmentType,
      dropEnabled,
    ).mapTo[MapFragmentFragment]
}

object MapFragmentFragments extends BasicOperations[MapFragmentFragment, MapFragmentFragmentsTable](new MapFragmentFragmentsTable(_)) {
  private def getByMapFragmentsType(fragmentType: MapFragmentType): Future[NonEmptyList[MapFragmentFragment]] =
    all.map(items => items.filter(_.fragmentType == fragmentType).sortBy(_.dropLevel)) map {
      case Nil          => throw new MatchError(s"Found 0 fragments of $fragmentType")
      case head :: tail => NonEmptyList(head, tail)
    }

  lazy val breachSplinters: Future[NonEmptyList[MapFragmentFragment]] =
    getByMapFragmentsType(MapFragment.Breachstone)
  lazy val emblemFragments: Future[NonEmptyList[MapFragmentFragment]] =
    getByMapFragmentsType(MapFragment.Emblem)
  lazy val simulacrumFragments: Future[NonEmptyList[MapFragmentFragment]] =
    getByMapFragmentsType(MapFragment.Simulacrum)
}
