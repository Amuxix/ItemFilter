package me.amuxix.items

import me.amuxix.{FilterRarity, Leveling}
import me.amuxix.providers.Provider

case class Gem(
  name: String,
  dropLevel: Int,
  level: Int,
  dropEnabled: Boolean,
  quality: Option[Int] = None,
) extends Item
    with Quality {
  def rarity(provider: Provider): FilterRarity = Leveling
  lazy val `class`: String = "Gem"
}
