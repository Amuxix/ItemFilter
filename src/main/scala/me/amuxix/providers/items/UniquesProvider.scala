package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.UniqueItem

case class UniquesProvider(all: NonEmptyList[UniqueItem]) extends BasicProvider[UniqueItem]
