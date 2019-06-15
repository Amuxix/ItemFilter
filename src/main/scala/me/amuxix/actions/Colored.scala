package me.amuxix.actions

import me.amuxix.InvalidArgument
import me.amuxix.actions.Colored.pow

object Colored {
  private def pow(x: Int, y: Int): Double =
    (x - y) * (x - y)
}

abstract class Colored(
  val _r: Int,
  val _g: Int,
  val _b: Int,
  val _a: Int
) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  Seq(_r, _g, _b, _a).foreach { p =>
    if (p < 0 || p > 255) {
      throw new InvalidArgument
    }
  }

  def distance(o: Colored): Double =
    math.sqrt(pow(_r, o._r) + pow(_g, o._g) + pow(_b, o._b) + pow(_a, o._a))
}
