package me.amuxix.providers.prices

import cats.effect.IO

private[prices] abstract class Provider {
  lazy val itemPrices: IO[Map[String, Double]] = prices.flatMap { prices =>
    IO.println("Got prices successfully").as {
      (("chaos orb", 1d) +: prices.map {
        case Price(name, chaosEquivalent) => name -> chaosEquivalent
      }).toMap
    }
  }

  protected def prices: IO[List[Price]]
}
