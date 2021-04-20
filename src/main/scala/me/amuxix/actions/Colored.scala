package me.amuxix.actions

import me.amuxix.InvalidArgument
import me.amuxix.actions.Colored.pow

object Colored {
  private def pow(x: Int, y: Int): Double =
    (x - y) * (x - y)
}

abstract class Colored {
  def r: Int
  def g: Int
  def b: Int
  def a: Int

  Seq(r, g, b, a).foreach { p =>
    if (p < 0 || p > 255) {
      throw new InvalidArgument
    }
  }

  def distance(o: Colored): Double =
    math.sqrt(pow(r, o.r) + pow(g, o.g) + pow(b, o.b) + pow(a, o.a))
}
