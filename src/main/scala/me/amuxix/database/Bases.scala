package me.amuxix.database

import me.amuxix.database.types.Item
import me.amuxix.database.types.Item.ItemType
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
    width: Option[Int]
  ): Base = itemType match {
    case Item.Amulet                => Amulet(name, dropLevel, dropEnabled)
    case Item.Belt                  => Belt(name, dropLevel, dropEnabled)
    case Item.Quiver                => Quiver(name, dropLevel, dropEnabled)
    case Item.Ring                  => Ring(name, dropLevel, dropEnabled)
    case Item.Talisman              => Talisman(name, dropLevel, dropEnabled)
    case Item.BodyArmour            => BodyArmour(name, dropLevel, dropEnabled)
    case Item.Boots                 => Boots(name, dropLevel, dropEnabled)
    case Item.Gloves                => Gloves(name, dropLevel, dropEnabled)
    case Item.Helmet                => Helmet(name, dropLevel, dropEnabled)
    case Item.LargeShield           => LargeShield(name, dropLevel, dropEnabled)
    case Item.MediumShield          => MediumShield(name, dropLevel, dropEnabled)
    case Item.SmallShield           => SmallShield(name, dropLevel, dropEnabled)
    case Item.HybridFlask           => HybridFlask(name, dropLevel, dropEnabled)
    case Item.LifeFlask             => LifeFlask(name, dropLevel, dropEnabled)
    case Item.ManaFlask             => ManaFlask(name, dropLevel, dropEnabled)
    case Item.UtilityFlask          => UtilityFlask(name, dropLevel, dropEnabled)
    case Item.Jewel                 => Jewel(name, dropEnabled)
    case Item.AbyssJewel            => AbyssJewel(name, dropEnabled)
    case Item.Bow                   => Bow(name, dropLevel, dropEnabled)
    case Item.Claw                  => Claw(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Dagger                => Dagger(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.RuneDaggers           => RuneDaggers(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandAxe            => OneHandAxe(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandMace           => OneHandMace(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.OneHandSword          => OneHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Sceptre               => Sceptre(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Staff                 => Staff(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Warstaves             => Warstaves(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.ThrustingOneHandSword => ThrustingOneHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandAxe            => TwoHandAxe(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandMace           => TwoHandMace(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.TwoHandSword          => TwoHandSword(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Wand                  => Wand(name, height.get, width.get, dropLevel, dropEnabled)
    case Item.Piece                 => Piece(name, dropEnabled)
    case Item.ClusterJewel          => ClusterJewel(name, dropEnabled)
  }

  def unapply(arg: Base): Option[(String, Int, Boolean, ItemType, Option[Int], Option[Int])] = ???

  override def * = (name, dropLevel, dropEnabled, itemType, height.?, width.?) <> ((baseFactory _).tupled, unapply)
}

object Bases extends BasicOperations[Base, BasesTable](new BasesTable(_))
