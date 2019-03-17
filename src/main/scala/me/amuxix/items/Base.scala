package me.amuxix.items

import cats.data.NonEmptyList
import me.amuxix.ImplicitConversions
import me.amuxix.ItemFilter.{cutoffs, ec}
import me.amuxix.conditions._
import me.amuxix.database.Bases

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class Base(name: String, height: Int, width: Int, val dropLevel: Int, `class`: String) extends Item(name, height, width, `class`) {
  val bestModsDropLevel: Int = 84
  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): Condition = Condition(
    base = Some(this.baseType),
    itemLevel = {
      val bestEquipment = Await.result(Base.bestEquipment, Duration.Inf)
      if (bestEquipment.toList contains this) None else Some(howClose)
    },
    rarity = rarity
  )

  def conditionsOfBestRaresForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10))

  def conditionsOfGoodRaresForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + 20))

  def conditionsOfBestWhitesForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10), Normal).copy(dropLevel = (bestModsDropLevel, 100))

  def withBestBaseBlocks(bestModsLevel: Int): Base with BestBaseBlocks = new Base(name, height, width, dropLevel, `class`) with BestBaseBlocks {
    override val bestModsDropLevel: Int = bestModsLevel
  }
}

sealed trait BestBaseBlocks extends ImplicitConversions { this: Base =>
  lazy val rare: Condition = Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = Rare)
  lazy val crafting: Condition = Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = (Normal, Magic))
}

object Base {
  def apply(name: String, height: Int, width: Int, dropLevel: Int, `class`: String): Base = new Base(name, height, width, dropLevel, `class`)

  def unapply(base: Base): Option[(String, Int, Int, Int, String)] = Some((base.name, base.height, base.width, base.dropLevel, base.`class`))

  val weapons =
    for {
      oneHandedAxes <- Bases.oneHandedAxes
      twoHandedAxes <- Bases.twoHandedAxes
      bows <- Bases.bows
      claws <- Bases.claws
      daggers <- Bases.daggers
      oneHandedMaces <- Bases.oneHandedMaces
      sceptres <- Bases.sceptres
      staffs <- Bases.staffs
      oneHandedSwords <- Bases.oneHandedSwords
      twoHandedSwords <- Bases.twoHandedSwords
      thrustingOneHandedSwords <- Bases.thrustingOneHandedSwords
      wands <- Bases.wands
    } yield NonEmptyList.fromListUnsafe(List(oneHandedAxes, twoHandedAxes, bows, claws, daggers, oneHandedMaces, sceptres, staffs, oneHandedSwords, twoHandedSwords, thrustingOneHandedSwords, wands))

  val armours =
    for {
      armours <- Bases.bodyArmours
      boots <- Bases.boots
      gloves <- Bases.gloves
      helmets <- Bases.helmets
    } yield NonEmptyList.fromListUnsafe(List(armours, boots, gloves, helmets))

  val accessories =
    for {
      rings <- Bases.rings
      belts <- Bases.belts
      amulets <- Bases.amulets
    } yield rings.concatNel(belts).concatNel(amulets)

  val bestEquipment =
    for {
      weps <- weapons
      arms <- armours
    } yield weps.concatNel(arms).flatMap(items => NonEmptyList.fromListUnsafe(items.filter(_.dropLevel >= cutoffs.bestBaseMinDropLevel)))

  val bestItems =
    for {
      bestEquips <- bestEquipment
      access <- accessories
    } yield bestEquips.concatNel(access)

  val allEquipment =
    for {
      weps <- weapons
      arms <- armours
    } yield weps.concatNel(arms).flatMap(identity)
}
