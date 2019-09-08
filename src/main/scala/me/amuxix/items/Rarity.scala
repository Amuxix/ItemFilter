package me.amuxix.items

import cats.effect.IO
import me.amuxix.FilterRarity

import scala.Predef.{Map => ScalaMap}

trait Rarity {
  def rarity(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): IO[FilterRarity]
}
