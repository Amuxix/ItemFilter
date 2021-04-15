package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.MapFragment.MapFragmentType
import me.amuxix.items.MapFragmentFragment

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

object MapFragmentFragments extends BasicOperations[MapFragmentFragment, MapFragmentFragmentsTable](new MapFragmentFragmentsTable(_))
