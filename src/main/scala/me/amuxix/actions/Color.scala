package me.amuxix.actions

import me.amuxix.actions.EffectColor.effectColors
import Ordering.Double.TotalOrdering
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
  val nets = Color(239, 143, 16)
  val incursionGreen = Color(95, 170, 120)
  val incursionRed = Color(173, 54, 42)
  val delveBlue = Color(21, 22, 96)

  private val darknessFactor = .15f
  private val lightenFactor = .3f

  def average(colors: Seq[Color]): Color = {
    val (redsGgreens, bluesAlphas) = colors.map(c => ((c.r, c.g), (c.b, c.a))).unzip
    val ((reds, greens), (blues, alphas)) = (redsGgreens.unzip, bluesAlphas.unzip)
    Color(
      reds.sum / reds.length,
      greens.sum / greens.size,
      blues.sum / blues.size,
      alphas.sum / alphas.size
    )
  }
}

case class Color(r: Int, g: Int, b: Int, a: Int) extends Colored(r, g, b, a) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  private def darken(color: Int): Int = Math.round(color * (1 - darknessFactor))
  private def lighten(color: Int): Int = Math.round(color + ((255 - color) * lightenFactor))

  def darken: Color = Color(darken(_r), darken(_g), darken(_b), _a)
  def lighten: Color = Color(lighten(_r), lighten(_g), lighten(_b), _a)
  def halfTransparent: Color = copy(a / 2)

  def closestEffectColor: EffectColor = effectColors.minBy(this.distance)
}