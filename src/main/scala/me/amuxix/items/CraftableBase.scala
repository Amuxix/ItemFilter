package me.amuxix.items

import me.amuxix.conditions._
import me.amuxix.providers.Provider

abstract class CraftableBase extends Base {
  val itemLevelToUnlockTopModTiers: Int = 84
  val itemLevel: Option[Int]
  val implicits: Seq[String]
  val prefixes: Seq[String]
  val suffixes: Seq[String]

  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(provider: Provider, howClose: ItemLevel, rarity: Option[Rarity] = Rare): Condition =
      Condition(
        base = Some(this.baseType),
        itemLevel = if (provider.bases.bestEquipment.toList.contains(this)) None else Some(howClose),
        rarity = rarity
      )

  def conditionsOfBestRaresForZoneLevel(provider: Provider): Condition =
    closeToZoneLevel(provider, ItemLevel(1, this.dropLevel + minDropBuffer max (this.dropLevel / 10)))

  def conditionsOfGoodRaresForZoneLevel(provider: Provider): Condition =
    closeToZoneLevel(provider, ItemLevel(1, this.dropLevel + 15))

  def conditionsOfBestWhitesForZoneLevel(provider: Provider): Condition =
    closeToZoneLevel(provider, ItemLevel(1, this.dropLevel + minDropBuffer max (this.dropLevel / 10)), Normal).copy(itemLevel = (itemLevelToUnlockTopModTiers, 100))

  lazy val topRare: Condition = Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = Rare)
  lazy val rare: Condition = Condition(base = Some(baseType), rarity = Rare)
  lazy val crafting: Condition = Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = (Normal, Magic))
}