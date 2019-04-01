package me.amuxix.items.bases.jewels

import me.amuxix.items.bases.{Jewel => BaseJewel}

case class AbyssJewel(
  name: String,
  dropEnabled: Boolean,
  itemLevel: Option[Int] = None,
  corrupted: Boolean = false,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty
) extends BaseJewel
