package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object BackgroundColor {
  implicit def color2Background(color: Color): BackgroundColor =
    new BackgroundColor(color)
  implicit def tuple32Background(color: (Int, Int, Int)): BackgroundColor =
    new BackgroundColor(color)
}

case class BackgroundColor(color: Color) extends Writable {
  override def print: String = s"SetBackgroundColor $color"
}
