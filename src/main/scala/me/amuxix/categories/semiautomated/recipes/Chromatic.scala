package me.amuxix.categories.semiautomated.recipes

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

class Chromatic(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) extends Sized {
  override lazy val condition: Condition = Condition(socketGroup = "RGB")
  override lazy val chaosValue: OptionT[IO, Double] =
    Currencies.getByName("Chromatic Orb").flatMap(_.chaosValuePerSlot(prices, parentLeaguePrices))
}
