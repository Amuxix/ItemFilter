package me.amuxix.conditions

import me.amuxix.Writable

object ElderItem {
  implicit def boolean2ElderItem(boolean: Boolean): ElderItem = ElderItem(boolean)
}

case class ElderItem(elderItem: Boolean) extends Writable {
  override protected def print = s"ElderItem $elderItem"
}
