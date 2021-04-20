package me.amuxix.actions

import cats.Show
import cats.syntax.show._

case class Beam(color: EffectColor, isTemp: Boolean = false)

object Beam {
  implicit val show: Show[Beam] = beam => show"PlayEffect ${beam.color} ${if (beam.isTemp) "Temp" else ""}"
}
