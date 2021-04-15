package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.IncursionItem

case class IncursionItemsProvider(all: NonEmptyList[IncursionItem]) extends BasicProvider[IncursionItem]
