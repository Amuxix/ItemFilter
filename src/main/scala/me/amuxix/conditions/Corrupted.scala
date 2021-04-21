package me.amuxix.conditions

import me.amuxix.Mergeable

object Corrupted {
  implicit val mergeable: Mergeable[Corrupted] = Mergeable.equal(_.is)
}

case class Corrupted(is: Boolean) extends ItemType[Corrupted]
