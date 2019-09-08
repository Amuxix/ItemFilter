package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

trait Dimensions extends Area {
  val height: Int
  val width: Int
  override lazy val area: OptionT[IO, Int] = OptionT.pure(height * width)
}
