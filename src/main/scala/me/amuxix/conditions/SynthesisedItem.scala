package me.amuxix.conditions

object SynthesisedItem {
}

case class SynthesisedItem(is: Boolean) extends ItemType[SynthesisedItem] {
  override def merge(other: SynthesisedItem): SynthesisedItem = this
}