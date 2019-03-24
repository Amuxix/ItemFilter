package me.amuxix.items.bases.accessories
import me.amuxix.items.bases.Accessory

case class Talisman(
  name: String,
  dropLevel: Int,
  dropEnabled: Boolean,
  itemLevel: Option[Int] = None,
  corrupted: Boolean = false,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty,
) extends Accessory {
  override lazy val `class`: String = "Amulet"
  override val height: Int = 1
  override val width: Int = 1
}