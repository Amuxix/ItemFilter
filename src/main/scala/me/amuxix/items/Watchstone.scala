package me.amuxix.items

import me.amuxix.{FilterRarity, Mythic}
import me.amuxix.providers.Provider

case class Watchstone(name: String, dropEnabled: Boolean) extends Item {
  override val dropLevel: Int = 1

  override def rarity(provider: Provider): FilterRarity = Mythic

  override val `class`: String = "Atlas Region Upgrade Item"
}
