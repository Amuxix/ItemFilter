package me.amuxix.actions

import me.amuxix.{Default, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Background extends Default[Background] {
  implicit def color2Background(color: Color): Background = new Background(color)
  implicit def tuple32Background(color: (Int, Int, Int)): Background = new Background(color)

  override val default = new Background(Color.default)
}

case class Background(color: Color) extends BaseAction with RefEquals {
  override def print: String = "SetBackgroundColor " + color.toString
}
