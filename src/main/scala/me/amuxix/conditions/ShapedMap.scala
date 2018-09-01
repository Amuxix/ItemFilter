package me.amuxix.conditions

import me.amuxix.Writable

object ShapedMap {
  implicit def boolean2ShapedMap(boolean: Boolean): ShapedMap = ShapedMap(boolean)
}

case class ShapedMap(shapedMap: Boolean) extends Writable {
  override protected def print = s"ShapedMap $shapedMap"
}
