package me.amuxix.conditions

import me.amuxix.Mergeable

object ShapedMap {
  implicit val mergeable: Mergeable[ShapedMap] = Mergeable.equal(_.is)
}

case class ShapedMap(is: Boolean) extends ItemType[ShapedMap]