package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

trait Dimensions extends Area {
  val height: Int
  val width: Int
  override lazy val area: OptionT[Future, Int] = OptionT.pure(height * width)
}
