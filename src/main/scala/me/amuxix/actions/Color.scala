package me.amuxix.actions

import me.amuxix.{Default, InvalidArgument}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Color extends Default[Color] {
  implicit def tuple32Color(tuple3: (Int, Int, Int)): Color = new Color(tuple3._1, tuple3._2, tuple3._3)

  def apply(r: Int, g: Int, b: Int): Color = new Color(r, g, b)

  override val default: Color = new Color(0, 0, 0, 0)
}

case class Color(r: Int, g: Int, b: Int, a: Int) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  Seq(r, g, b, a).foreach { p =>
    if (p < 0 || p > 255) {
      throw new InvalidArgument
    }
  }

  override def toString: String = s"$r $g $b${if (a < 255) " " + a else ""}"
}
