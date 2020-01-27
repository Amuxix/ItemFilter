package me.amuxix.conditions

object Corrupted {
  implicit def boolean2Corrupted(boolean: Boolean): Corrupted =
    Corrupted(boolean)
}

case class Corrupted(is: Boolean) extends ItemType[Corrupted](is) {
  override def merge(other: Corrupted): Corrupted = this
}
