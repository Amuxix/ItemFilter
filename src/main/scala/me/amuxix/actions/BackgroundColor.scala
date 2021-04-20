package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
object BackgroundColor {
}

case class BackgroundColor(color: Color) extends Writable {
  override def print: String = s"SetBackgroundColor $color"
}
