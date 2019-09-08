package me.amuxix.items.currency

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.database.Currencies
import me.amuxix.items.{Currency, PriceFallback}

case class CurrencyFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  override def calculateFallbackPrice(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): OptionT[IO, Double] =
    for {
      currency <- OptionT(Currencies.all.map(_.find(_.name == fragmentOf)))
      value <- currency.chaosValuePerSlot(prices, parentLeaguePrices)
    } yield value / stackSize
}
