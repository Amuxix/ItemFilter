package me.amuxix.items

import me.amuxix.conditions.Condition

case class Map(_name: String, tier: Int, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Maps", _dropEnabled) {
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  def sameTierOrUpgrade: Condition = condition.copy(itemLevel = mapLevel)
  def good: Condition = condition.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1))
}
