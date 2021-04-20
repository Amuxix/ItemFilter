package me.amuxix.conditions

object FracturedItem {
}

case class FracturedItem(is: Boolean) extends ItemType[FracturedItem] {
  override def merge(other: FracturedItem): FracturedItem = this
}