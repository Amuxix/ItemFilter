package me.amuxix.conditions

import me.amuxix.Writable

object ShaperItem {
  implicit def boolean2ShaperItem(boolean: Boolean): ShaperItem = ShaperItem(boolean)
}

case class ShaperItem(shaperItem: Boolean) extends Writable {
  override protected def print = s"ShaperItem $shaperItem"
}