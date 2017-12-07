package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object Background {
  implicit def color2Background(color: Color): Background = new Background(color)
  implicit def tuple32Background(color: (Int, Int, Int)): Background = new Background(color)
}

case class Background(color: Color) extends Writable {
  override def print: String = "SetBackgroundColor " + color.toString
}
