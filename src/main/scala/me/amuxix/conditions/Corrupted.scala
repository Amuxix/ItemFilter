package me.amuxix.conditions

object Corrupted {
}

case class Corrupted(is: Boolean) extends ItemType[Corrupted] {
  override def merge(other: Corrupted): Corrupted = this
}
