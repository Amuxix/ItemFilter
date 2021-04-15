package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.database.types.Currency
import me.amuxix.items.currency._
import me.amuxix.items.Currency

case class CurrenciesProvider(all: NonEmptyList[Currency]) extends BasicProvider[Currency] {
  lazy val nets: NonEmptyList[Net] = getByType(Currency.Net)
  lazy val orbs: NonEmptyList[Orb] = getByType(Currency.Orb)
  lazy val vials: NonEmptyList[Vial] = getByType(Currency.Vial)
  lazy val fossils: NonEmptyList[Fossil] = getByType(Currency.Fossil)
  lazy val oils: NonEmptyList[Oil] = getByType(Currency.Oil)
  lazy val catalysts: NonEmptyList[Catalyst] = getByType(Currency.Catalyst)
  lazy val deliriumOrbs: NonEmptyList[DeliriumOrb] = getByType(Currency.DeliriumOrb)
}
