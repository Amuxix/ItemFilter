package me.amuxix.items

import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.providers.Provider

case class IncursionItem(name: String, dropEnabled: Boolean) extends Item {
  override val dropLevel: Int = 1
  override val `class`: String = "Incursion Item"
  override def rarity(provider: Provider): FilterRarity = AlwaysShow
}
