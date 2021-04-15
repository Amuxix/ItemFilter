package me.amuxix.providers.items

import cats.data.NonEmptyList
import cats.syntax.flatMap._
import me.amuxix.items._
import me.amuxix.items.bases.{Accessory, Armour, Flask, Weapon}
import me.amuxix.items.bases.accessories._
import me.amuxix.items.bases.armour._
import me.amuxix.items.bases.jewels._
import me.amuxix.items.bases.weapons._
import me.amuxix.ItemFilter.cutoffs
import me.amuxix.database.types.Item
import me.amuxix.items.bases.flasks._


case class BasesProvider(
  all: NonEmptyList[Base],
) extends BasicProvider[Base] {
  lazy val lifeFlasks: NonEmptyList[LifeFlask] = getByType(Item.LifeFlask)
  lazy val manaFlasks: NonEmptyList[ManaFlask] = getByType(Item.ManaFlask)
  lazy val hybridFlasks: NonEmptyList[HybridFlask] = getByType(Item.HybridFlask)

  lazy val abyssJewel: NonEmptyList[AbyssJewel] = getByType(Item.Jewel)
  lazy val jewel: NonEmptyList[Jewel] = getByType(Item.Jewel)
  lazy val talismans: NonEmptyList[Talisman] = getByType(Item.Talisman)

  lazy val rings: NonEmptyList[Ring] = getByType(Item.Ring)
  lazy val amulets: NonEmptyList[Amulet] = getByType(Item.Amulet)
  lazy val belts: NonEmptyList[Belt] = getByType(Item.Belt)
  lazy val quivers: NonEmptyList[Quiver] = getByType(Item.Quiver)
  lazy val bodyArmours: NonEmptyList[BodyArmour] = getByType(Item.BodyArmour)
  lazy val helmets: NonEmptyList[Helmet] = getByType(Item.Helmet)
  lazy val smallShields: NonEmptyList[SmallShield] = getByType(Item.SmallShield)
  lazy val mediumShields: NonEmptyList[MediumShield] = getByType(Item.MediumShield)
  lazy val largeShields: NonEmptyList[LargeShield] = getByType(Item.LargeShield)
  lazy val gloves: NonEmptyList[Gloves] = getByType(Item.Gloves)
  lazy val boots: NonEmptyList[Boots] = getByType(Item.Boots)
  lazy val oneHandAxes: NonEmptyList[OneHandAxe] = getByType(Item.OneHandAxe)
  lazy val twoHandAxes: NonEmptyList[TwoHandAxe] = getByType(Item.TwoHandAxe)
  lazy val bows: NonEmptyList[Bow] = getByType(Item.Bow)
  lazy val claws: NonEmptyList[Claw] = getByType(Item.Claw)
  lazy val daggers: NonEmptyList[Dagger] = getByType(Item.Dagger)
  lazy val runeDaggers: NonEmptyList[RuneDaggers] = getByType(Item.RuneDaggers)
  lazy val oneHandMaces: NonEmptyList[OneHandMace] = getByType(Item.OneHandMace)
  lazy val sceptres: NonEmptyList[Sceptre] = getByType(Item.Sceptre)
  lazy val staffs: NonEmptyList[Staff] = getByType(Item.Staff)
  lazy val warstaves: NonEmptyList[Warstaves] = getByType(Item.Warstaves)
  lazy val oneHandSwords: NonEmptyList[OneHandSword] = getByType(Item.OneHandSword)
  lazy val twoHandSwords: NonEmptyList[TwoHandSword] = getByType(Item.TwoHandSword)
  lazy val thrustingOneHandSwords: NonEmptyList[ThrustingOneHandSword] = getByType(Item.ThrustingOneHandSword)
  lazy val wands: NonEmptyList[Wand] = getByType(Item.Wand)

  lazy val flasks: NonEmptyList[Flask] = NonEmptyList.of(lifeFlasks, manaFlasks, hybridFlasks).flatten

  lazy val shields: NonEmptyList[Armour] = NonEmptyList.of(smallShields, mediumShields, largeShields).flatten

  lazy val weapons: NonEmptyList[Weapon] =
    NonEmptyList.of(oneHandAxes, twoHandAxes, bows, claws, daggers, runeDaggers, oneHandMaces, sceptres, staffs, warstaves, oneHandSwords, twoHandSwords, thrustingOneHandSwords, wands).flatten

  lazy val armours: NonEmptyList[Armour] =
    NonEmptyList.of(bodyArmours, boots, gloves, helmets, shields).flatten

  lazy val accessories: NonEmptyList[Accessory] =
    NonEmptyList.of(rings, belts, amulets).flatten

  lazy val bestEquipment: NonEmptyList[CraftableBase with Corruptible with Quality with Sockets] =
    NonEmptyList.of(weapons, armours).flatMap{ items =>
      NonEmptyList.fromListUnsafe(items.filter(_.dropLevel >= cutoffs.bestBaseMinDropLevel))
    }

  lazy val bestItems: NonEmptyList[CraftableBase with Corruptible] =
    NonEmptyList.of(bestEquipment, accessories).flatten

  lazy val allEquipment: NonEmptyList[CraftableBase with Corruptible] =
    NonEmptyList.of(weapons, armours, accessories, quivers).flatten
}
