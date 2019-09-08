package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

import scala.Predef.{Map => ScalaMap}

trait PriceFallback { item: ProviderPrice =>
  def calculateFallbackPrice(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double]
}
