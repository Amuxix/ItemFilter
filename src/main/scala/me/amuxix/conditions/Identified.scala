package me.amuxix.conditions

import me.amuxix.Mergeable

object Identified {
  implicit val mergeable: Mergeable[Identified] = Mergeable.equal(_.is)
}

case class Identified(is: Boolean) extends ItemType[Identified]