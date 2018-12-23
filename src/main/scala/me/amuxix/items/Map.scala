package me.amuxix.items

import me.amuxix.conditions.Condition

class Map(name: String, val tier: Int) extends Item(name, 1, 1, "Maps") {
  private val mapLevel = 67 + tier //The -2 accounts for bosses and rares dropping items 2 levels higher then the zone
  def sameTierOrUpgrade: Condition = condition.copy(itemLevel = mapLevel)
  def good: Condition = condition.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1))
}

object Map {
  def apply(name: String, tier: Int): Map = new Map(name, tier)
  def unapply(arg: Map): Option[(String, Int)] = Some((arg.name, arg.tier))
}
