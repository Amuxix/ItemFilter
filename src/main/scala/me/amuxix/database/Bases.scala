package me.amuxix.database

import cats.data.NonEmptyList
import cats.implicits.{catsStdInstancesForFuture, toNonEmptyTraverseOps}
import me.amuxix.ItemFilter.{cutoffs, ec}
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

import scala.concurrent.Future

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
    case Item.RuneDaggers => RuneDaggers(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandAxe => OneHandAxe(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandMace => OneHandMace(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandSword => OneHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Sceptre => Sceptre(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Staff => Staff(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Warstaves => Warstaves(name, height.get, width.get, dropLevel, dropEnabled)
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
  private def getByItemType[Type](itemType: ItemType): Future[NonEmptyList[Type]] =
    all.map(_.filter(_.className == itemType.toString).sortBy(_.dropLevel).map(_.asInstanceOf[Type])) map {
      case Nil =>
        println(s"Found 0 bases of $itemType")
        throw new MatchError(s"Found 0 bases of $itemType")
      case head :: tail => NonEmptyList(head, tail)
    }

  lazy val flasks: Future[NonEmptyList[Flask]] = {
    for {
      lifeFlasks <- getByItemType(Item.LifeFlask)
      manaFlasks <- getByItemType(Item.ManaFlask)
      hybridFlasks <- getByItemType(Item.HybridFlask)
    } yield lifeFlasks.concatNel(manaFlasks).concatNel(hybridFlasks)
  }

  lazy val abyssJewel: Future[NonEmptyList[AbyssJewel]] = getByItemType(Item.Jewel)
  lazy val jewel: Future[NonEmptyList[Jewel]] = getByItemType(Item.Jewel)
  lazy val talismans: Future[NonEmptyList[AbyssJewel]] = getByItemType(Item.Talisman)

  lazy val rings: Future[NonEmptyList[Ring]] = getByItemType(Item.Ring)
  lazy val amulets: Future[NonEmptyList[Amulet]] = getByItemType(Item.Amulet)
  lazy val belts: Future[NonEmptyList[Belt]] = getByItemType(Item.Belt)
  lazy val bodyArmours: Future[NonEmptyList[BodyArmour]] = getByItemType(Item.BodyArmour)
  lazy val helmets: Future[NonEmptyList[Helmet]] = getByItemType(Item.Helmet)
  lazy val gloves: Future[NonEmptyList[Gloves]] = getByItemType(Item.Gloves)
  lazy val boots: Future[NonEmptyList[Boots]] = getByItemType(Item.Boots)
  lazy val oneHandAxes: Future[NonEmptyList[OneHandAxe]] = getByItemType(Item.OneHandAxe)
  lazy val twoHandAxes: Future[NonEmptyList[TwoHandAxe]] = getByItemType(Item.TwoHandAxe)
  lazy val bows: Future[NonEmptyList[Bow]] = getByItemType(Item.Bow)
  lazy val claws: Future[NonEmptyList[Claw]] = getByItemType(Item.Claw)
  lazy val daggers: Future[NonEmptyList[Dagger]] = getByItemType(Item.Dagger)
  lazy val runeDaggers: Future[NonEmptyList[RuneDaggers]] = getByItemType(Item.RuneDaggers)
  lazy val oneHandMaces: Future[NonEmptyList[OneHandMace]] = getByItemType(Item.OneHandMace)
  lazy val sceptres: Future[NonEmptyList[Sceptre]] = getByItemType(Item.Sceptre)
  lazy val staffs: Future[NonEmptyList[Staff]] = getByItemType(Item.Staff)
  lazy val warstaves: Future[NonEmptyList[Warstaves]] = getByItemType(Item.Warstaves)
  lazy val oneHandSwords: Future[NonEmptyList[OneHandSword]] = getByItemType(Item.OneHandSword)
  lazy val twoHandSwords: Future[NonEmptyList[TwoHandSword]] = getByItemType(Item.TwoHandSword)
  lazy val thrustingOneHandSwords: Future[NonEmptyList[ThrustingOneHandSword]] =
    getByItemType(Item.ThrustingOneHandSword)
  lazy val wands: Future[NonEmptyList[Wand]] = getByItemType(Item.Wand)

  val weapons: Future[NonEmptyList[Weapon]] =
    NonEmptyList.of(oneHandAxes, twoHandAxes, bows, claws, daggers, runeDaggers, oneHandMaces, sceptres, staffs, warstaves, oneHandSwords, twoHandSwords, thrustingOneHandSwords, wands).nonEmptyFlatSequence

  val armours: Future[NonEmptyList[Armour]] =
    NonEmptyList.of(bodyArmours, boots, gloves, helmets).nonEmptyFlatSequence

  val accessories: Future[NonEmptyList[Accessory]] =
    NonEmptyList.of(rings, belts, amulets).nonEmptyFlatSequence

  val bestEquipment: Future[NonEmptyList[CraftableBase with Corruptible with Quality with Sockets]] =
    NonEmptyList.of(weapons, armours).nonEmptyFlatTraverse { futureItems =>
      futureItems.map { items =>
        NonEmptyList.fromListUnsafe(
          items.filter(_.dropLevel >= cutoffs.bestBaseMinDropLevel)
        )
      }
    }

  val bestItems: Future[NonEmptyList[CraftableBase with Corruptible]] =
    NonEmptyList.of(bestEquipment, accessories).nonEmptyFlatSequence

  val allEquipment: Future[NonEmptyList[CraftableBase with Corruptible]] =
    NonEmptyList.of(weapons, armours, accessories).nonEmptyFlatSequence
}
