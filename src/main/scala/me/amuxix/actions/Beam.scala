package me.amuxix.actions

import me.amuxix.Writable

case class Beam(color: EffectColor, isTemp: Boolean = false) extends Writable {
  override protected def print: String = s"PlayEffect ${color.name} ${if (isTemp) "Temp" else ""}"
}
