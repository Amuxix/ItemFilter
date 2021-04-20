package me.amuxix.actions

import me.amuxix.Writable

sealed trait Shape
case object Star extends Shape
case object Hexagon extends Shape
case object Diamond extends Shape
case object Square extends Shape
case object Triangle extends Shape
case object Circle extends Shape
case object Cross extends Shape
case object Moon extends Shape
case object Raindrop extends Shape
case object Kite extends Shape
case object Pentagon extends Shape
case object UpsideDownHouse extends Shape


sealed trait IconSize
case object Large extends IconSize {
  override def toString: String = "0"
}
case object Medium extends IconSize {
  override def toString: String = "1"
}
case object Small extends IconSize {
  override def toString: String = "2"
}

object MinimapIcon {
}

case class MinimapIcon(color: EffectColor, shape: Shape, size: IconSize = Small) extends Writable {
  override protected def print: String =
    s"MinimapIcon $size ${color.className} $shape"
}
