package me.amuxix.conditions

object AlternateQuality {
}

case class AlternateQuality(is: Boolean) extends ItemType[AlternateQuality] {
  override def merge(other: AlternateQuality): AlternateQuality = this
}