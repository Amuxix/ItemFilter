package me.amuxix.database

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits.toNonEmptyTraverseOps
import me.amuxix.ItemFilter.cutoffs
import me.amuxix.database.types.Item.ItemType
import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.Item
import me.amuxix.items._
import me.amuxix.items.bases.{Jewel => _, _}
import me.amuxix.items.bases.accessories._
import me.amuxix.items.bases.armour._
import me.amuxix.items.bases.flasks._
import me.amuxix.items.bases.jewels._
import me.amuxix.items.bases.weapons._

class BasesTable(tag: Tag) extends Table[Base](tag, "bases") with CommonColumns[Base] {
  def dropLevel = column[Int]("drop_level")
  def itemType = column[ItemType]("item_type")
  def height = column[Int]("height")
  def width = column[Int]("width")

  private def baseFactory(
    name: String,
    dropLevel: Int,
    dropEnabled: Boolean,
    itemType: ItemType,
    height: Option[Int],
    width: Option[Int]): Base = itemType match {
    case Item.Amulet => Amulet(name, dropLevel, dropEnabled)
    case Item.Belt => Belt(name, dropLevel, dropEnabled)
    case Item.Quiver => Quiver(name, dropLevel, dropEnabled)
    case Item.Ring => Ring(name, dropLevel, dropEnabled)
    case Item.Talisman => Talisman(name, dropLevel, dropEnabled)
    case Item.BodyArmour => BodyArmour(name, dropLevel, dropEnabled)
    case Item.Boots => Boots(name, dropLevel, dropEnabled)
    case Item.Gloves => Gloves(name, dropLevel, dropEnabled)
    case Item.Helmet => Helmet(name, dropLevel, dropEnabled)
    case Item.LargeShield => LargeShield(name, dropLevel, dropEnabled)
    case Item.MediumShield => MediumShield(name, dropLevel, dropEnabled)
    case Item.SmallShield => SmallShield(name, dropLevel, dropEnabled)
    case Item.HybridFlask => HybridFlask(name, dropLevel, dropEnabled)
    case Item.LifeFlask => LifeFlask(name, dropLevel, dropEnabled)
    case Item.ManaFlask => ManaFlask(name, dropLevel, dropEnabled)
    case Item.UtilityFlask => UtilityFlask(name, dropLevel, dropEnabled)
    case Item.Jewel => Jewel(name, dropEnabled)
    case Item.AbyssJewel => AbyssJewel(name, dropEnabled)
    case Item.Bow => Bow(name, dropLevel, dropEnabled)
    case Item.Claw => Claw(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Dagger => Dagger(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.RuneDagger => RuneDagger(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandAxe => OneHandAxe(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandMace => OneHandMace(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandSword => OneHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Sceptre => Sceptre(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Staff => Staff(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Warstaff => Warstaff(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.ThrustingOneHandSword => ThrustingOneHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandAxe => TwoHandAxe(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandMace => TwoHandMace(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandSword => TwoHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Wand => Wand(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Piece => Piece(name, dropEnabled)
  }

  def unapply(arg: Base): Option[(String, Int, Boolean, ItemType, Option[Int], Option[Int])] = ???

  override def * =
    (
      name,
      dropLevel,
      dropEnabled,
      itemType,
      height.?,
      width.?,
    ) <> ((baseFactory _).tupled, unapply)
}

object Bases extends BasicOperations[Base, BasesTable](new BasesTable(_)) {
  private def getByItemType[Type](itemType: ItemType): IO[NonEmptyList[Type]] =
    all.map(items => items.filter(_.className == itemType.toString).sortBy(_.dropLevel).map(_.asInstanceOf[Type])) map {
      case Nil =>
        println(s"Found 0 bases of $itemType")
        throw new MatchError(s"Found 0 bases of $itemType")
      case head :: tail => NonEmptyList(head, tail)
    }

  lazy val flasks: IO[NonEmptyList[Flask]] = {
    for {
      lifeFlasks <- getByItemType(Item.LifeFlask)
      manaFlasks <- getByItemType(Item.ManaFlask)
      hybridFlasks <- getByItemType(Item.HybridFlask)
    } yield lifeFlasks.concatNel(manaFlasks).concatNel(hybridFlasks)
  }

  lazy val abyssJewel: IO[NonEmptyList[AbyssJewel]] = getByItemType(Item.Jewel)
  lazy val jewel: IO[NonEmptyList[Jewel]] = getByItemType(Item.Jewel)
  lazy val talismans: IO[NonEmptyList[AbyssJewel]] = getByItemType(Item.Talisman)

  lazy val rings: IO[NonEmptyList[Ring]] = getByItemType(Item.Ring)
  lazy val amulets: IO[NonEmptyList[Amulet]] = getByItemType(Item.Amulet)
  lazy val belts: IO[NonEmptyList[Belt]] = getByItemType(Item.Belt)
  lazy val bodyArmours: IO[NonEmptyList[BodyArmour]] = getByItemType(Item.BodyArmour)
  lazy val helmets: IO[NonEmptyList[Helmet]] = getByItemType(Item.Helmet)
  lazy val gloves: IO[NonEmptyList[Gloves]] = getByItemType(Item.Gloves)
  lazy val boots: IO[NonEmptyList[Boots]] = getByItemType(Item.Boots)
  lazy val oneHandAxes: IO[NonEmptyList[OneHandAxe]] = getByItemType(Item.OneHandAxe)
  lazy val twoHandAxes: IO[NonEmptyList[TwoHandAxe]] = getByItemType(Item.TwoHandAxe)
  lazy val bows: IO[NonEmptyList[Bow]] = getByItemType(Item.Bow)
  lazy val claws: IO[NonEmptyList[Claw]] = getByItemType(Item.Claw)
  lazy val daggers: IO[NonEmptyList[Dagger]] = getByItemType(Item.Dagger)
  lazy val runeDaggers: IO[NonEmptyList[RuneDagger]] = getByItemType(Item.RuneDagger)
  lazy val oneHandMaces: IO[NonEmptyList[OneHandMace]] = getByItemType(Item.OneHandMace)
  lazy val sceptres: IO[NonEmptyList[Sceptre]] = getByItemType(Item.Sceptre)
  lazy val staffs: IO[NonEmptyList[Staff]] = getByItemType(Item.Staff)
  lazy val warstaffs: IO[NonEmptyList[Warstaff]] = getByItemType(Item.Warstaff)
  lazy val oneHandSwords: IO[NonEmptyList[OneHandSword]] = getByItemType(Item.OneHandSword)
  lazy val twoHandSwords: IO[NonEmptyList[TwoHandSword]] = getByItemType(Item.TwoHandSword)
  lazy val thrustingOneHandSwords: IO[NonEmptyList[ThrustingOneHandSword]] =
    getByItemType(Item.ThrustingOneHandSword)
  lazy val wands: IO[NonEmptyList[Wand]] = getByItemType(Item.Wand)

  val weapons: IO[NonEmptyList[Weapon]] =
    NonEmptyList.of(oneHandAxes, twoHandAxes, bows, claws, daggers, runeDaggers, oneHandMaces, sceptres, staffs, warstaffs, oneHandSwords, twoHandSwords, thrustingOneHandSwords, wands).nonEmptyFlatSequence

  val armours: IO[NonEmptyList[Armour]] =
    NonEmptyList.of(bodyArmours, boots, gloves, helmets).nonEmptyFlatSequence

  val accessories: IO[NonEmptyList[Accessory]] =
    NonEmptyList.of(rings, belts, amulets).nonEmptyFlatSequence

  val bestEquipment: IO[NonEmptyList[CraftableBase with Corruptible with Quality with Sockets]] =
    NonEmptyList.of(weapons, armours).nonEmptyFlatTraverse { futureItems =>
      futureItems.map { items =>
        NonEmptyList.fromListUnsafe(
          items.filter(_.dropLevel >= cutoffs.bestBaseMinDropLevel)
        )
      }
    }

  val bestItems: IO[NonEmptyList[CraftableBase with Corruptible]] =
    NonEmptyList.of(bestEquipment, accessories).nonEmptyFlatSequence

  val allEquipment: IO[NonEmptyList[CraftableBase with Corruptible]] =
    NonEmptyList.of(weapons, armours, accessories).nonEmptyFlatSequence
}
