package me.amuxix.items.mapfragments
import me.amuxix.items.MapFragment

case class Breachstone(
  name: String,
  dropEnabled: Boolean,
) extends MapFragment {
  override val dropLevel: Int = 1
}