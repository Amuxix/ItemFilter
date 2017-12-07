package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object Border {
  implicit def color2Border(color: Color): Border = new Border(color)
  implicit def tuple32Border(color: (Int, Int, Int)): Border = new Border(color)
}

case class Border(color: Color) extends Writable {
  override def print: String = "SetBorderColor " + color.toString
}