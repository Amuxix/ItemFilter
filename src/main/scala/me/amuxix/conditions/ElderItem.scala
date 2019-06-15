package me.amuxix.conditions

object ElderItem {
  implicit def boolean2ElderItem(boolean: Boolean): ElderItem =
    ElderItem(boolean)
}

case class ElderItem(is: Boolean) extends ItemType(is)
