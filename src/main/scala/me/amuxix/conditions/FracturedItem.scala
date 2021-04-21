package me.amuxix.conditions

import me.amuxix.Mergeable

object FracturedItem {
  implicit val mergeable: Mergeable[FracturedItem] = Mergeable.equal(_.is)
}

case class FracturedItem(is: Boolean) extends ItemType[FracturedItem]