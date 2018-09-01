package me.amuxix.actions

import me.amuxix.Writable

case class Beam(color: Color, isTemp: Boolean) extends Writable {
  override protected def print: String = s"PlayEffect $color ${if (isTemp) "Temp" else ""}"
}
