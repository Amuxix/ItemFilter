package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.database.MapFragments
import me.amuxix.database.types.MapFragment.MapFragmentType

import scala.Predef.{Map => ScalaMap}

case class MapFragmentFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  fragmentType: MapFragmentType,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  override def calculateFallbackPrice(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] =
    for {
      mapFragment <- OptionT(MapFragments.all.map(_.find(_.name == fragmentOf)))
      value <- mapFragment.chaosValuePerSlot(prices, parentLeaguePrices)
    } yield value / stackSize
}
