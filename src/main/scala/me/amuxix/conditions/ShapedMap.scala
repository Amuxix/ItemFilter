package me.amuxix.conditions

object ShapedMap {
  implicit def boolean2ShapedMap(boolean: Boolean): ShapedMap =
    ShapedMap(boolean)
}

case class ShapedMap(is: Boolean) extends ItemType[ShapedMap](is) {
  override def merge(other: ShapedMap): ShapedMap = this
}