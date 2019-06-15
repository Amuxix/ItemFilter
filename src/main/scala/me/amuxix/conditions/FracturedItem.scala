package me.amuxix.conditions

object FracturedItem {
  implicit def boolean2FracturedItem(boolean: Boolean): FracturedItem =
    FracturedItem(boolean)
}

case class FracturedItem(is: Boolean) extends ItemType(is)
