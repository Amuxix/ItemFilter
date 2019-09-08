package me.amuxix.actions

import me.amuxix.actions.EffectColor.effectColors
//import Ordering.Double.TotalOrdering
import me.amuxix.actions.Color.{darknessFactor, lightenFactor}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Color {
  implicit def tuple32Color(tuple3: (Int, Int, Int)): Color = new Color(tuple3._1, tuple3._2, tuple3._3)

  def apply(r: Int, g: Int, b: Int): Color = new Color(r, g, b)

  val transparent = Color(0, 0, 0, 0)
  val nearTransparent = Color(255, 255, 255, 64)
  val defaultBackground = Color(0, 0, 0, 230)

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
  val prophecyPink = Color(181, 75, 255)
  val chaosBlue = Color(0, 64, 255)
  val regalPurple = Color(82, 0, 155)
  val shelder = Color(50, 130, 165)
  val nets = Color(239, 143, 16)
  val incursionGreen = Color(95, 170, 120)
  val incursionRed = Color(173, 54, 42)
  val delveBlue = Color(21, 22, 96)
  val delveOrange = Color(255, 166, 50)
  val scarabBlue = Color(0, 50, 130)
  val incubatorOrange = Color(255, 201, 7)
  val emblemTeal = Color(7, 255, 172)
  val blightOrange = Color(249, 150, 25)
  val blightBlue = Color(10, 0, 76)

  private val darknessFactor = .15f
  private val lightenFactor = .3f

  implicit class ListUnzip4[+A](val list: Seq[A]) extends AnyVal {

    def unzip4[A1, A2, A3, A4](implicit asTuple4: A => (A1, A2, A3, A4)): (Seq[A1], Seq[A2], Seq[A3], Seq[A4]) = {
      val b1 = Seq.newBuilder[A1]
      val b2 = Seq.newBuilder[A2]
      val b3 = Seq.newBuilder[A3]
      val b4 = Seq.newBuilder[A4]

      for (abcd <- list) {
        val (a, b, c, d) = asTuple4(abcd)
        b1 += a
        b2 += b
        b3 += c
        b4 += d
      }
      (b1.result(), b2.result(), b3.result(), b4.result())
    }
  }

  def average(colors: Seq[Color]): Color = {
    val (reds, greens, blues, alphas) =
      colors.map(c => (c.r, c.g, c.b, c.a)).unzip4
    Color(
      reds.sum / reds.size,
      greens.sum / greens.size,
      blues.sum / blues.size,
      alphas.sum / alphas.size
    )
  }
}

case class Color(
  r: Int,
  g: Int,
  b: Int,
  a: Int
) extends Colored(r, g, b, a) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  private def darken(color: Int): Int = Math.round(color * (1 - darknessFactor))
  private def lighten(color: Int): Int = Math.round(color + ((255 - color) * lightenFactor))

  def darken: Color = Color(darken(_r), darken(_g), darken(_b), _a)
  def lighten: Color = Color(lighten(_r), lighten(_g), lighten(_b), _a)
  def halfTransparent: Color = copy(a = a / 2)

  def closestEffectColor: EffectColor = effectColors.minBy(this.distance)

  override def toString: String = s"$r $g $b${if (a < 255) " " + a else ""}"
}
