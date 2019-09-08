package me.amuxix.items

import cats.effect.IO
import me.amuxix.conditions._
import me.amuxix.database.Bases

abstract class CraftableBase extends Base {
  val itemLevelToUnlockTopModTiers: Int = 84
  val itemLevel: Option[Int]
  val implicits: Seq[String]
  val prefixes: Seq[String]
  val suffixes: Seq[String]

  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): IO[Condition] =
    Bases.bestEquipment.map { bestEquipment =>
      Condition(
        base = Some(this.baseType),
        itemLevel = if (bestEquipment.toList contains this) None else Some(howClose),
        rarity = rarity
      )
    }

  def conditionsOfBestRaresForZoneLevel: IO[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10))

  def conditionsOfGoodRaresForZoneLevel: IO[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + 20))

  def conditionsOfBestWhitesForZoneLevel: IO[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10), Normal).map(_.copy(itemLevel = (itemLevelToUnlockTopModTiers, 100)))

  lazy val rare: IO[Condition] = IO.pure(Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = Rare))
  lazy val crafting: IO[Condition] = IO.pure(Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = (Normal, Magic)))
}