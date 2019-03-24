package me.amuxix.items.bases.weapons
import me.amuxix.items.bases.Weapon

case class TwoHandMace(
  name: String,
  height: Int,
  width: Int,
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
) extends Weapon