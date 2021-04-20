package me.amuxix.conditions

object ShapedMap {
}

case class ShapedMap(is: Boolean) extends ItemType[ShapedMap] {
  override def merge(other: ShapedMap): ShapedMap = this
}