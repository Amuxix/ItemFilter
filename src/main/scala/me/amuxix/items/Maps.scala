package me.amuxix.items

import me.amuxix.Uncommon
import me.amuxix.conditions.Condition

abstract class Maps(mapLevel: Int) extends GenItem(Uncommon) {
  val tier: Int = mapLevel - 67
  override val condition = Condition(`class` = "Maps", mapTier = tier)
  def sameTierOrUpgrade: Condition = condition.copy(itemLevel = mapLevel)
  def good: Condition = condition.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1))
}

object Maps {
  val maps = Seq(
    Tier1,
    Tier2,
    Tier3,
    Tier4,
    Tier5,
    Tier6,
    Tier7,
    Tier8,
    Tier9,
    Tier10,
    Tier11,
    Tier12,
    Tier13,
    Tier14,
    Tier15,
    Tier16,
  )
}

case object Tier1 extends Maps(68)
case object Tier2 extends Maps(69)
case object Tier3 extends Maps(70)
case object Tier4 extends Maps(71)
case object Tier5 extends Maps(72)
case object Tier6 extends Maps(73)
case object Tier7 extends Maps(74)
case object Tier8 extends Maps(75)
case object Tier9 extends Maps(76)
case object Tier10 extends Maps(77)
case object Tier11 extends Maps(78)
case object Tier12 extends Maps(79)
case object Tier13 extends Maps(80)
case object Tier14 extends Maps(81)
case object Tier15 extends Maps(82)
case object Tier16 extends Maps(83)
