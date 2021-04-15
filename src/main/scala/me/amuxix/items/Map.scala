package me.amuxix.items

import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

case class Map(name: String, tier: Int, dropEnabled: Boolean) extends Item {
  override def rarity(provider: Provider): FilterRarity = AlwaysShow

  override val dropLevel: Int = tier match {
    case 1 => 58
    case _ => tier + 57
  }
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  lazy val sameTierOrUpgrade: Condition =
    condition.copy(itemLevel = mapLevel)
  lazy val good: Condition =
    condition.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1))
  lazy val `class`: String = "Map"
}
