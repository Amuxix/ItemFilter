package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

import scala.Predef.{Map => ScalaMap}

trait PurePrice extends Price {
  def chaosValuePerSlot: Double

  final override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] = OptionT.pure(chaosValuePerSlot)
}
