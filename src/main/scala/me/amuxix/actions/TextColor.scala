package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object TextColor {
  implicit def color2Text(color: Color): TextColor = new TextColor(color)
  implicit def tuple32Text(color: (Int, Int, Int)): TextColor =
    new TextColor(color)
}

case class TextColor(color: Color) extends Writable {
  override def print: String = "SetTextColor " + color.toString
}
