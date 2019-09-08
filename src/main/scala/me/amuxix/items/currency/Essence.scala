package me.amuxix.items.currency

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.database.Essences
import me.amuxix.items.{Currency, PriceFallback}


case class Essence(name: String, upgradesTo: Option[String], dropEnabled: Boolean) extends Currency with PriceFallback {
  override val stackSize: Int = 1
  override val dropLevel: Int = 1

  override def calculateFallbackPrice(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): OptionT[IO, Double] =
    for {
      upgrade <- OptionT.fromOption[IO](upgradesTo)
      essence <- OptionT(Essences.all.map(_.find(_.name == upgrade)))
      value <- essence.chaosValuePerSlot(prices, parentLeaguePrices)
    } yield value / 3
}
