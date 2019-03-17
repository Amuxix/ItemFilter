package me.amuxix.items

import cats.data.NonEmptyList
import me.amuxix.ImplicitConversions
import me.amuxix.ItemFilter.{cutoffs, ec}
import me.amuxix.conditions._
import me.amuxix.database.Bases

import scala.concurrent.Future

case class Base(_name: String, _height: Int, _width: Int, dropLevel: Int, _class: String, _dropEnabled: Boolean) extends Item(_name, _height, _width, _class, _dropEnabled) { outer =>
  val bestModsDropLevel: Int = 84
  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(_name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): Future[Condition] = Base.bestEquipment.map { bestEquipment =>
    Condition(
      base = Some(this.baseType),
      itemLevel = if (bestEquipment.toList contains this) None else Some(howClose),
      rarity = rarity
    )
  }

  def conditionsOfBestRaresForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10))

  def conditionsOfGoodRaresForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + 20))

  def conditionsOfBestWhitesForZoneLevel: Future[Condition] =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10), Normal).map(_.copy(itemLevel = (bestModsDropLevel, 100)))

  def withBestBaseBlocks(bestModsLevel: Int): Base with BestBaseBlocks = new Base(_name, _height, _width, dropLevel, _class, _dropEnabled) with BestBaseBlocks {
    override val bestModsDropLevel: Int = bestModsLevel
  }
}

sealed trait BestBaseBlocks extends ImplicitConversions { this: Base =>
  lazy val rare: Future[Condition] = Future.successful(Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = Rare))
  lazy val crafting: Future[Condition] = Future.successful(Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = (Normal, Magic)))
}

object Base {
  def tupled = (apply _).tupled

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
