package me.amuxix.items

import me.amuxix.conditions.Condition
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

case class Map(_name: String, tier: Int, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Maps", _dropEnabled) {
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  lazy val sameTierOrUpgrade: Future[Condition] = condition.map(_.copy(itemLevel = mapLevel))
  lazy val good: Future[Condition] = condition.map(_.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1)))
}
