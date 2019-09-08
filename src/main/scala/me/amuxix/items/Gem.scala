package me.amuxix.items

import me.amuxix.FilterRarity
import me.amuxix.FilterRarity.Priced.Leveling

case class Gem(
  name: String,
  dropLevel: Int,
  level: Int,
  dropEnabled: Boolean,
  quality: Option[Int] = None,
) extends Item with Quality with PureRarity {
  override val rarity: FilterRarity = Leveling
  lazy val `class`: String = "Gem"
}
