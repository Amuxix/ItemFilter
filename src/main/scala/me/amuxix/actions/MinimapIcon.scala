package me.amuxix.actions

import me.amuxix.Writable

sealed trait Shape
case object Circle extends Shape
case object Diamond extends Shape
case object Hexagon extends Shape
case object Square extends Shape
case object Star extends Shape
case object Triangle extends Shape

sealed trait IconSize
case object Large extends IconSize
case object Medium extends IconSize
case object Small extends IconSize

case class MinimapIcon(size: IconSize, color: EffectColor, shape: Shape) extends Writable {
  override protected def print: String = s"MinimapIcon $size $color $shape"
}
