package me.amuxix.actions

import me.amuxix.{Default, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Text extends Default[Text] {
  override val default = new Text(Color.default)
  implicit def color2Text(color: Color): Text = new Text(color)
  implicit def tuple32Text(color: (Int, Int, Int)): Text = new Text(color)
}

case class Text(color: Color) extends BaseAction with RefEquals {
  override def print: String = "SetTextColor " + color.toString
}
