package me.amuxix.conditions

import me.amuxix.Mergeable

object SynthesisedItem {
  implicit val mergeable: Mergeable[SynthesisedItem] = Mergeable.equal(_.is)
}

case class SynthesisedItem(is: Boolean) extends ItemType[SynthesisedItem]