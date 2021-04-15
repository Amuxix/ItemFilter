package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.currency.CurrencyFragment

case class CurrencyFragmentsProvider(all: NonEmptyList[CurrencyFragment]) extends BasicProvider[CurrencyFragment]
