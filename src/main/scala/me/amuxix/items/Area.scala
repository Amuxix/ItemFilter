package me.amuxix.items

import cats.data.OptionT

import scala.concurrent.Future

trait Area {
  val area: OptionT[Future, Int]
}
