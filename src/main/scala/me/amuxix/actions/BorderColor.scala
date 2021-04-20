package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object BorderColor {
}

case class BorderColor(color: Color) extends Writable {
  override def print: String = s"SetBorderColor $color"
}
