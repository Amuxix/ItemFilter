package me.amuxix.items

import me.amuxix.FilterRarity
import me.amuxix.FilterRarity.AlwaysShow

case class IncursionItem(name: String, dropEnabled: Boolean) extends Item with PureRarity {
  override val dropLevel: Int = 1
  override val `class`: String = "Incursion Item"
  override val rarity: FilterRarity = AlwaysShow
}
