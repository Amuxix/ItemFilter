package me.amuxix.conditions

import me.amuxix.Writable

object Corrupted {
  implicit def boolean2Corrupted(boolean: Boolean): Corrupted = Corrupted(boolean)
}

case class Corrupted(corrupted: Boolean) extends Writable {
  override protected def print = s"Corrupted $corrupted"
}