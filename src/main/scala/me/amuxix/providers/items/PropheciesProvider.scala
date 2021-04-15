package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.currency.Prophecy

case class PropheciesProvider(all: NonEmptyList[Prophecy]) extends BasicProvider[Prophecy]
