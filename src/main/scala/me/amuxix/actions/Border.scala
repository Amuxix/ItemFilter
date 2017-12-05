package me.amuxix.actions

import me.amuxix.{Default, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Border extends Default[Border] {
  override val default = new Border(Color.default)
  implicit def color2Border(color: Color): Border = new Border(color)
  implicit def tuple32Border(color: (Int, Int, Int)): Border = new Border(color)
}

case class Border(color: Color) extends BaseAction with RefEquals {
  override def print: String = "SetBorderColor " + color.toString
}