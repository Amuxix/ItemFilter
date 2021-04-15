package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.currency.Essence

case class EssencesProvider(all: NonEmptyList[Essence]) extends BasicProvider[Essence]
