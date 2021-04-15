package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.database.types.MapFragment
import me.amuxix.items.MapFragment
import me.amuxix.items.mapfragments._

case class MapFragmentsProvider(all: NonEmptyList[MapFragment]) extends BasicProvider[MapFragment] {
  lazy val breachstones: NonEmptyList[Breachstone] = getByType(MapFragment.Breachstone)
  lazy val miscFragments: NonEmptyList[Misc] = getByType(MapFragment.Misc)
  lazy val mortalFragments: NonEmptyList[Mortal] = getByType(MapFragment.Mortal)
  lazy val prophecyFragments: NonEmptyList[Breachstone] = getByType(MapFragment.Breachstone)
  lazy val sacrificeFragments: NonEmptyList[Sacrifice] = getByType(MapFragment.Sacrifice)
  lazy val scarabs: NonEmptyList[Scarab] = getByType(MapFragment.Scarab)
  lazy val shaperFragments: NonEmptyList[Shaper] = getByType(MapFragment.Shaper)
  lazy val emblems: NonEmptyList[Emblem] = getByType(MapFragment.Emblem)
  lazy val metamorph: NonEmptyList[Metamorph] = getByType(MapFragment.Metamorph)
  lazy val simulacrum: NonEmptyList[Metamorph] = getByType(MapFragment.Simulacrum)
}
