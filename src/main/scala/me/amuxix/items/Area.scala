package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO

trait Area {
  val area: OptionT[IO, Int]
}
