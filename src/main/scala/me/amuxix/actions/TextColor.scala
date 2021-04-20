package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object TextColor {
}

case class TextColor(color: Color) extends Writable {
  override def print: String = s"SetTextColor $color"
}
