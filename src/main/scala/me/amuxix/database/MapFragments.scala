package me.amuxix.database

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
      case MapFragment.Metamorph   => Metamorph(name, dropEnabled)
      case MapFragment.Simulacrum  => Simulacrum(name, dropEnabled)
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

object MapFragments extends BasicOperations[MapFragment, MapFragmentsTable](new MapFragmentsTable(_))
