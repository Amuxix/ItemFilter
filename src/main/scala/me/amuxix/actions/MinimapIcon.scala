package me.amuxix.actions

import me.amuxix.Writable
import me.amuxix.actions.IconSize.Small

sealed trait Shape

object Shape {
  case object Star extends Shape
  case object Hexagon extends Shape
  case object Diamond extends Shape
  case object Square extends Shape
  case object Triangle extends Shape
  case object Circle extends Shape
}


sealed trait IconSize

object IconSize {
  case object Large extends IconSize {
    override def toString: String = "0"
  }
  case object Medium extends IconSize {
    override def toString: String = "1"
  }
  case object Small extends IconSize {
    override def toString: String = "2"
  }
}

object MinimapIcon {
  implicit def tuple22MinimapIcon(tuple: (EffectColor, Shape)): MinimapIcon =
    MinimapIcon(tuple._1, tuple._2)
  implicit def tuple32MinimapIcon(tuple: (EffectColor, Shape, IconSize)): MinimapIcon =
    MinimapIcon(tuple._1, tuple._2, tuple._3)
}

case class MinimapIcon(color: EffectColor, shape: Shape, size: IconSize = Small) extends Writable {
  override protected def print: String =
    s"MinimapIcon $size ${color.className} $shape"
}
