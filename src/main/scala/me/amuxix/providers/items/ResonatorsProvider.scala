package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.currency.Resonator

case class ResonatorsProvider(all: NonEmptyList[Resonator]) extends BasicProvider[Resonator] {
  lazy val chaotic: NonEmptyList[Resonator] =
    NonEmptyList.fromListUnsafe(all.filter(_.reforges))

  lazy val alchemical: NonEmptyList[Resonator] =
    NonEmptyList.fromListUnsafe(all.filter(_.reforges == false))
}
