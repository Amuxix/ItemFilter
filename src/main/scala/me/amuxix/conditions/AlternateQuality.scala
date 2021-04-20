package me.amuxix.conditions

object AlternateQuality {
  implicit def boolean2AlternateQuality(boolean: Boolean): AlternateQuality =
    AlternateQuality(boolean)
}

case class AlternateQuality(is: Boolean) extends ItemType[AlternateQuality] {
  override def merge(other: AlternateQuality): AlternateQuality = this
}