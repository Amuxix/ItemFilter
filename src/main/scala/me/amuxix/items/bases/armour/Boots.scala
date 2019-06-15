package me.amuxix.items.bases.armour
import me.amuxix.items.bases.Armour
import me.amuxix.items.Variant.Variation

case class Boots(
  name: String,
  dropLevel: Int,
  dropEnabled: Boolean,
  itemLevel: Option[Int] = None,
  corrupted: Boolean = false,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty,
  quality: Option[Int] = None,
  sockets: Option[Int] = None,
  links: Option[Int] = None,
  socketGroup: Option[String] = None,
  variant: Option[Variation] = None,
) extends Armour {
  override val height: Int = 2
  override val width: Int = 2
}
