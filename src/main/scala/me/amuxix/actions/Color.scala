package me.amuxix.actions

import me.amuxix.InvalidArgument

/**
  * Created by Amuxix on 03/03/2017.
  */
object Color {
  implicit def tuple32Color(tuple3: (Int, Int, Int)): Color = new Color(tuple3._1, tuple3._2, tuple3._3)

  def apply(r: Int, g: Int, b: Int): Color = new Color(r, g, b)

  val black = Color(0, 0, 0)
  val white = Color(255, 255, 255)
  val red = Color(255, 0, 0)
  val darkRed = Color(150, 0, 0)
  val teal = Color(27, 162, 155)
}

sealed case class Color(r: Int, g: Int, b: Int, a: Int) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  Seq(r, g, b, a).foreach { p =>
    if (p < 0 || p > 255) {
      throw new InvalidArgument
    }
  }

  override def toString: String = s"$r $g $b${if (a < 255) " " + a else ""}"
}
