package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.Map

case class MapsProvider(all: NonEmptyList[Map]) extends BasicProvider[Map]
