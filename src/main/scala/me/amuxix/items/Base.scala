package me.amuxix.items

import me.amuxix.ImplicitConversions
import me.amuxix.conditions._

class Base(name: String, height: Int, width: Int, val dropLevel: Int, `class`: String) extends Item(name, height, width, `class`) {
  val bestModsDropLevel: Int = 84
  val minDropBuffer: Int = 5

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): Condition = Condition(
    base = Some(this.baseType),
    itemLevel = ???, //if (Base.bestEquipment contains this) None else Some(howClose),
    rarity = rarity
  )

  def conditionsOfBestRaresForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10))

  def conditionsOfGoodRaresForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + 20))

  def conditionsOfBestWhitesForZoneLevel: Condition =
    closeToZoneLevel(ItemLevel(1, this.dropLevel + minDropBuffer max this.dropLevel / 10), Normal)
}

sealed trait BestBaseBlocks extends ImplicitConversions { this: Base =>
  lazy val rare: Condition = Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = Rare)
  lazy val crafting: Condition = Condition(base = Some(baseType), itemLevel = (bestModsDropLevel, 100), rarity = (Normal, Magic))
}

/*abstract class Armour(height: Int, width: Int, dropLevel: Int, `class`: String) extends Base(, height, width, dropLevel, `class`) with BestBaseBlocks with Corruptible with Elder with Shaper with HasSockets with HasRarity

abstract class Weapon(height: Int, width: Int, dropLevel: Int, `class`: String) extends Base(, height, width, dropLevel, `class`) with BestBaseBlocks with Corruptible with Elder with Shaper with HasSockets with HasRarity {
  override val bestModsDropLevel: Int = 83
}*/

abstract class Accessory(dropLevel: Int, `class`: String) extends Base("", 1, 1, dropLevel, `class`) with BestBaseBlocks
// format: off
object Base {
  def apply(name: String, height: Int, width: Int, dropLevel: Int, `class`: String): Base = new Base(name, height, width, dropLevel, `class`)

  def unapply(base: Base): Option[(String, Int, Int, Int, String)] = Some((base.name, base.height, base.width, base.dropLevel, base.`class`))

  /*val weapons: Seq[Seq[Weapon]] = Seq(OneHandedAxe.all, TwoHandedAxe.all, Bow.all, Claw.all, Dagger.all, OneHandedMace.all, Sceptre.all, Staff.all, OneHandedSword.all, TwoHandedSword.all, ThrustingOneHandedSword.all, Wand.all)

  val armours: Seq[Seq[Armour]] = BodyArmour.bodyArmours ++ Boots.boots ++ Gloves.gloves ++ Helmet.helmets ++ Shield.shields

  val flasks: Seq[Seq[Flask]] = Seq(LifeFlask.all, ManaFlask.all, HybridFlask.all)

  val accessories: Seq[Seq[Accessory]] = Seq(Amulet.all ++ Ring.all ++ Belt.all)

  val bestEquipment: Seq[Base with BestBaseBlocks] = (weapons ++ armours).flatMap(_.takeRight(2)) ++ Seq(SpikePointArrowQuiver, BroadheadArrowQuiver).sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
  val bestItems: Seq[Base with BestBaseBlocks] = bestEquipment ++ accessories.flatten
  val allEquipment: Seq[Base] = (weapons ++ armours).flatten.sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)*/
  val weapons = ???

  val armours = ???

  val flasks = ???

  val accessories = ???

  val bestEquipment = ???
  val bestItems = ???
  val allEquipment = ???
}
// format: on
