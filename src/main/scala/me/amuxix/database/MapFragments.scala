package me.amuxix.database

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.MapFragment
import me.amuxix.database.types.MapFragment.MapFragmentType
import me.amuxix.items.MapFragment
import me.amuxix.items.mapfragments._

class MapFragmentsTable(tag: Tag) extends Table[MapFragment](tag, "map_fragments") with CommonColumns[MapFragment] {
  def fragmentType = column[MapFragmentType]("fragment_type")

  private def mapFragmentFactory(name: String, fragmentType: MapFragmentType, dropEnabled: Boolean): MapFragment =
    fragmentType match {
      case MapFragment.Breachstone => Breachstone(name, dropEnabled)
      case MapFragment.Misc        => Misc(name, dropEnabled)
      case MapFragment.Mortal      => Mortal(name, dropEnabled)
      case MapFragment.Prophecy    => Prophecy(name, dropEnabled)
      case MapFragment.Sacrifice   => Sacrifice(name, dropEnabled)
      case MapFragment.Scarab      => Scarab(name, dropEnabled)
      case MapFragment.Shaper      => Shaper(name, dropEnabled)
      case MapFragment.Emblem      => Emblem(name, dropEnabled)
    }

  def unapply(mapFragment: MapFragment): Option[(String, MapFragmentType, Boolean)] =
    ???

  override def * =
    (
      name,
      fragmentType,
      dropEnabled,
    ) <> ((mapFragmentFactory _).tupled, unapply)
}

object MapFragments extends BasicOperations[MapFragment, MapFragmentsTable](new MapFragmentsTable(_)) {
  private def getByMapFragmentsType[Type](fragmentType: MapFragmentType): IO[NonEmptyList[Type]] =
    all.map(items => items.filter(_.className == fragmentType.toString).sortBy(_.dropLevel).map(_.asInstanceOf[Type])) map {
      case Nil          => throw new MatchError(s"Found 0 fragments of $fragmentType")
      case head :: tail => NonEmptyList(head, tail)
    }

  lazy val breachstones: IO[NonEmptyList[Breachstone]] =
    getByMapFragmentsType(MapFragment.Breachstone)
  lazy val miscsFragments: IO[NonEmptyList[Misc]] = getByMapFragmentsType(MapFragment.Misc)
  lazy val mortalFragments: IO[NonEmptyList[Mortal]] =
    getByMapFragmentsType(MapFragment.Mortal)
  lazy val prophecyFragments: IO[NonEmptyList[Breachstone]] =
    getByMapFragmentsType(MapFragment.Breachstone)
  lazy val sacrificeFragments: IO[NonEmptyList[Sacrifice]] =
    getByMapFragmentsType(MapFragment.Sacrifice)
  lazy val scarabs: IO[NonEmptyList[Scarab]] = getByMapFragmentsType(MapFragment.Scarab)
  lazy val shaperFragments: IO[NonEmptyList[Shaper]] =
    getByMapFragmentsType(MapFragment.Shaper)
  lazy val emblems: IO[NonEmptyList[Emblem]] = getByMapFragmentsType(MapFragment.Emblem)
}
