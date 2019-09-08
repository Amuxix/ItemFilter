package me.amuxix.items

import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.conditions.Condition
import me.amuxix.FilterRarity.AlwaysShow

case class Map(name: String, tier: Int, dropEnabled: Boolean) extends Item with PureRarity {
  override val rarity: FilterRarity = AlwaysShow

  override val dropLevel: Int = tier match {
    case 1 => 58
    case _ => tier + 57
  }
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  lazy val sameTierOrUpgrade: IO[Condition] =
    condition.map(_.copy(itemLevel = mapLevel))
  lazy val good: IO[Condition] =
    condition.map(_.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1)))
  lazy val `class`: String = "Map"
}
