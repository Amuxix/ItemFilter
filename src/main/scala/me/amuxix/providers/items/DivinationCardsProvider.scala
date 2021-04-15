package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.DivinationCard

case class DivinationCardsProvider(all: NonEmptyList[DivinationCard]) extends BasicProvider[DivinationCard]
