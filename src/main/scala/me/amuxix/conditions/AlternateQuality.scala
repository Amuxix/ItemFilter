package me.amuxix.conditions

import me.amuxix.Mergeable

object AlternateQuality {
  implicit val mergeable: Mergeable[AlternateQuality] = Mergeable.equal(_.is)
}

case class AlternateQuality(is: Boolean) extends ItemType[AlternateQuality]