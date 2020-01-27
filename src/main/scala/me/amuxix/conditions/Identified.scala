package me.amuxix.conditions

object Identified {
  implicit def boolean2Identified(boolean: Boolean): Identified =
    Identified(boolean)
}

case class Identified(is: Boolean) extends ItemType[Identified](is) {
  override def merge(other: Identified): Identified = this
}