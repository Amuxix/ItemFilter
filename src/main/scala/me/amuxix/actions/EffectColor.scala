package me.amuxix.actions

import cats.Show
import me.amuxix.Named

object EffectColor {
  lazy val all = Seq(Red, Green, Blue, Brown, White, Yellow, Cyan, Grey, Orange, Pink, Purple)

  implicit val show: Show[EffectColor] = _.className
}

sealed abstract class EffectColor(val r: Int, val g: Int, val b: Int) extends Colored with Named {
  override lazy val a: Int = 255
}

case object Red extends EffectColor(255, 0, 0)
case object Green extends EffectColor(0, 255, 0)
case object Blue extends EffectColor(0, 0, 255)
case object Brown extends EffectColor(175, 96, 37)
case object White extends EffectColor(255, 255, 255)
case object Yellow extends EffectColor(255, 255, 0)
case object Cyan extends EffectColor(0, 255, 255)
case object Grey extends EffectColor(128, 128, 128)
case object Orange extends EffectColor(255, 165, 0)
case object Pink extends EffectColor(255, 192, 203)
case object Purple extends EffectColor(128,0,128)