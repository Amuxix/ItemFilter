package me.amuxix.conditions

import me.amuxix.Writable

object Identified {
  implicit def boolean2Identified(boolean: Boolean): Identified =
    Identified(boolean)
}

case class Identified(identified: Boolean) extends Writable {
  override protected def print = s"Identified $identified"
}
