package me.amuxix.categories.semiautomated.recipes

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.ItemFilter
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

class Scrap(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.config.armourClasses ++ ItemFilter.config.shieldClasses, quality = 20)
  override lazy val chaosValue: OptionT[IO, Double] =
    Currencies.getByName("Armourer's Scrap").flatMap(_.chaosValuePerSlot(prices, parentLeaguePrices))
}
