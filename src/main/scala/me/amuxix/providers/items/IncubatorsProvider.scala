package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.Incubator

case class IncubatorsProvider(all: NonEmptyList[Incubator]) extends BasicProvider[Incubator]
