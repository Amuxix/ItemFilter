package me.amuxix.conditions

object Identified {
}

case class Identified(is: Boolean) extends ItemType[Identified] {
  override def merge(other: Identified): Identified = this
}