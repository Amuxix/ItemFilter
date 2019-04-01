package me.amuxix.items.bases.accessories
import me.amuxix.items.bases.Accessory
import me.amuxix.items.Variant.Variation

case class Ring(
  name: String,
  dropLevel: Int,
  dropEnabled: Boolean,
  itemLevel: Option[Int] = None,
  corrupted: Boolean = false,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty,
  variant: Option[Variation] = None,
) extends Accessory {
  override val height: Int = 1
  override val width: Int = 1
}