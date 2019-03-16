package me.amuxix.conditions

object ShaperItem {
  implicit def boolean2ShaperItem(boolean: Boolean): ShaperItem = ShaperItem(boolean)
}

case class ShaperItem(is: Boolean) extends ItemType(is)
