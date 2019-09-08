package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

case class Incubator(name: String, dropEnabled: Boolean) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override val area: OptionT[IO, Int] = OptionT.pure(1)
  override val `class`: String = "Incubator"
}
