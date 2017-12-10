package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object BorderColor {
  implicit def color2Border(color: Color): BorderColor = new BorderColor(color)
  implicit def tuple32Border(color: (Int, Int, Int)): BorderColor = new BorderColor(color)
}

case class BorderColor(color: Color) extends Writable {
  override def print: String = "SetBorderColor " + color.toString
}