package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.database.types.MapFragment
import me.amuxix.items.MapFragmentFragment

case class MapFragmentFragmentsProvider(all: NonEmptyList[MapFragmentFragment]) extends BasicProvider[MapFragmentFragment] {
  lazy val breachSplinters: NonEmptyList[MapFragmentFragment] = getByType(MapFragment.Breachstone)
  lazy val emblemFragments: NonEmptyList[MapFragmentFragment] = getByType(MapFragment.Emblem)
  lazy val simulacrumFragments: NonEmptyList[MapFragmentFragment] = getByType(MapFragment.Simulacrum)
}
