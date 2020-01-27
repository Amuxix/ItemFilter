package me.amuxix.conditions

object SynthesisedItem {
  implicit def boolean2SynthesisedItem(boolean: Boolean): SynthesisedItem =
    SynthesisedItem(boolean)
}

case class SynthesisedItem(is: Boolean) extends ItemType[SynthesisedItem](is) {
  override def merge(other: SynthesisedItem): SynthesisedItem = this
}