package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.Watchstone

case class WatchstonesProvider(all: NonEmptyList[Watchstone]) extends BasicProvider[Watchstone]
