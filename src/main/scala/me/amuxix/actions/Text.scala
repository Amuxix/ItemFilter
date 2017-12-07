package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object Text {
  implicit def color2Text(color: Color): Text = new Text(color)
  implicit def tuple32Text(color: (Int, Int, Int)): Text = new Text(color)
}

case class Text(color: Color) extends Writable {
  override def print: String = "SetTextColor " + color.toString
}
