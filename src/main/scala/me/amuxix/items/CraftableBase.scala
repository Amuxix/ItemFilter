package me.amuxix.items

import me.amuxix.ItemFilter.ec
import me.amuxix.conditions._
import me.amuxix.database.Bases

import scala.concurrent.Future

abstract class CraftableBase extends Base {
  val itemLevelToUnlockTopModTiers: Int = 84
  val itemLevel: Option[Int]
  val implicits: Seq[String]
  val prefixes: Seq[String]
  val suffixes: Seq[String]

  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): Future[Condition] =
    Bases.bestEquipment.map { bestEquipment =>
      Condition(
        base = Some(this.baseType),
        itemLevel = if (bestEquipment.toList contains this) None else Some(howClose),
        rarity = rarity
      )
    }

  def conditionsOfBestRaresForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max (this.dropLevel / 10)))

  def conditionsOfGoodRaresForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + 20))

  def conditionsOfBestWhitesForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max (this.dropLevel / 10)), Normal).map(_.copy(itemLevel = (itemLevelToUnlockTopModTiers, 100)))

  lazy val topRare: Future[Condition] = Future.successful(Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = Rare))
  lazy val rare: Future[Condition] = Future.successful(Condition(base = Some(baseType), rarity = Rare))
  lazy val crafting: Future[Condition] = Future.successful(Condition(base = Some(baseType), itemLevel = (itemLevelToUnlockTopModTiers, 100), rarity = (Normal, Magic)))
}

object CraftableBase {}
