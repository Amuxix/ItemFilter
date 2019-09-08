package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

import scala.Predef.{println, Map => ScalaMap}

trait ProviderPrice extends Price { this: Item with Area =>

  def getChaosEquivalentFor(item: Item, prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] = {
    val name = item.name
    val lowerName = name.toLowerCase
    OptionT.fromOption[IO](prices.get(lowerName))
      .orElse(item match {
        case fallback: PriceFallback =>
          println(s"Using fallback price for $name")
          fallback.calculateFallbackPrice(prices, parentLeaguePrices)
        case _ =>
          OptionT.none
      })
      .transform(_.orElse(parentLeaguePrices.get(lowerName)))
      .orElse {
        item match {
          case item if item.dropEnabled == false =>
            println(s"$name drop is disabled")
            OptionT.none
          case _ =>
            println(s"No price for $name")
            OptionT.none
        }
      }
  }
  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] =
    for {
      value <- getChaosEquivalentFor(this, prices, parentLeaguePrices)
      area <- area
    } yield value / area
}
