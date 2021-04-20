package me.amuxix.actions

import cats.Show
import me.amuxix.actions.IconSize.{IconSize, Small}
import cats.syntax.show._
import me.amuxix.Named

sealed trait Shape

object Shape {
  implicit val show: Show[Shape] = Named.className _
}

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


object IconSize extends Enumeration {
  type IconSize = Value
  val Large = Value(0)
  val Medium = Value(1)
  val Small = Value(2)

  implicit val show: Show[IconSize] = Show.show(_.id.toString)
}

case class MinimapIcon(color: EffectColor, shape: Shape, size: IconSize = Small)

object MinimapIcon {
  implicit val show: Show[MinimapIcon] = icon => show"MinimapIcon ${icon.size} ${icon.color} ${icon.shape}"
}
