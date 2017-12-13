package me.amuxix.actions

import me.amuxix.InvalidArgument
import me.amuxix.actions.Color.{darknessFactor, lightenFactor}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Color {
  implicit def tuple32Color(tuple3: (Int, Int, Int)): Color = new Color(tuple3._1, tuple3._2, tuple3._3)

  def apply(r: Int, g: Int, b: Int): Color = new Color(r, g, b)

  val transparent = Color(0, 0, 0, 0)

  val unique = Color(175, 96, 37)

  val black = Color(0, 0, 0)
  val white = Color(255, 255, 255)
  val red = Color(255, 0, 0)
  val darkRed = Color(150, 0, 0)
  val teal = Color(27, 162, 155)
  val slimeGreen = Color(198, 255, 30)
  val pink = Color(208, 32, 144)
  val purple = Color(111, 0, 240)
  val legacyBlue = Color(0, 60, 210)
  val lightGreen = Color(50, 255, 50, 200)
  val goodYellow = Color(255, 255, 0)
  val blue = Color(27, 66, 130)
  val divinationBlue = Color(14, 186, 255)
  val chaosBlue = Color(0, 64, 255)
  val regalPurple = Color(82, 0, 155)
  val shelder = Color(50, 130, 165)

  private val darknessFactor = .15f
  private val lightenFactor = .3f
}

sealed case class Color(r: Int, g: Int, b: Int, a: Int) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  Seq(r, g, b, a).foreach { p =>
    if (p < 0 || p > 255) {
      throw new InvalidArgument
    }
  }

  private def darken(color: Int): Int = Math.round(color * (1 - darknessFactor))
  private def lighten(color: Int): Int = Math.round(color + ((255 - color) * lightenFactor))

  def darken: Color = Color(darken(r), darken(g), darken(b), a)
  def lighten: Color = Color(lighten(r), lighten(g), lighten(b), a)


  override def toString: String = s"$r $g $b${if (a < 255) " " + a else ""}"
}
