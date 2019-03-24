package me.amuxix.items

import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.conditions.Condition
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

case class Map (
  name: String,
  tier: Int,
  dropEnabled: Boolean,
) extends Item {
  override val rarity: Future[FilterRarity] = Future.successful(AlwaysShow)

  override val dropLevel: Int = tier match {
    case 1 => 58
    case _ => tier + 57
  }
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  lazy val sameTierOrUpgrade: Future[Condition] = condition.map(_.copy(itemLevel = mapLevel))
  lazy val good: Future[Condition] = condition.map(_.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1)))
}