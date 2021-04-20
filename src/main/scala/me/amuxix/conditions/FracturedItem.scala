package me.amuxix.conditions

object FracturedItem {
  implicit def boolean2FracturedItem(boolean: Boolean): FracturedItem =
    FracturedItem(boolean)
}

case class FracturedItem(is: Boolean) extends ItemType[FracturedItem] {
  override def merge(other: FracturedItem): FracturedItem = this
}