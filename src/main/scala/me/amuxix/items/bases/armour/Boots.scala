package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Armour

sealed abstract class Boots(dropLevel: Int) extends Armour(2, 2, dropLevel, "Boots")

object Boots extends FilterClass[Boots] {
  // format: off
  val armourBoots: Seq[Boots] = Seq(IronGreaves, SteelGreaves, PlatedGreaves, ReinforcedGreaves, AntiqueGreaves, AncientGreaves, GoliathGreaves, VaalGreaves, TitanGreaves)
  val evasionBoots: Seq[Boots] = Seq(RawhideBoots, GoathideBoots, DeerskinBoots, NubuckBoots, EelskinBoots, SharkskinBoots, ShagreenBoots, StealthBoots, SlinkBoots)
  val energyShieldBoots: Seq[Boots] = Seq(WoolShoes, VelvetSlippers, SilkSlippers, ScholarBoots, SatinSlippers, SamiteSlippers, ConjurerBoots, ArcanistSlippers, SorcererBoots)
  val armourEvasionBoots: Seq[Boots] = Seq(LeatherscaleBoots, IronscaleBoots, BronzescaleBoots, SteelscaleBoots, SerpentscaleBoots, WyrmscaleBoots, HydrascaleBoots, DragonscaleBoots, TwoTonedBoots)
  val armourEnergyShieldBoots: Seq[Boots] = Seq(ChainBoots, RingmailBoots, MeshBoots, RivetedBoots, ZealotBoots, SoldierBoots, LegionBoots, CrusaderBoots)
  val evasionEnergyShieldBoots: Seq[Boots] = Seq(WrappedBoots, StrappedBoots, ClaspedBoots, ShackledBoots, TrapperBoots, AmbushBoots, CarnalBoots, AssassinsBoots, MurderBoots)
  val boots: Seq[Seq[Boots]] = Seq(armourBoots, evasionBoots, energyShieldBoots, armourEvasionBoots, armourEnergyShieldBoots, evasionEnergyShieldBoots)
  // format: on
  override val all: Seq[Boots] = boots.flatten
}

//Armour
case object IronGreaves extends Boots(dropLevel = 1)
case object SteelGreaves extends Boots(dropLevel = 9)
case object PlatedGreaves extends Boots(dropLevel = 23)
case object ReinforcedGreaves extends Boots(dropLevel = 33)
case object AntiqueGreaves extends Boots(dropLevel = 37)
case object AncientGreaves extends Boots(dropLevel = 46)
case object GoliathGreaves extends Boots(dropLevel = 54)
case object VaalGreaves extends Boots(dropLevel = 62)
case object TitanGreaves extends Boots(dropLevel = 68)

//Evasion
case object RawhideBoots extends Boots(dropLevel = 3)
case object GoathideBoots extends Boots(dropLevel = 12)
case object DeerskinBoots extends Boots(dropLevel = 22)
case object NubuckBoots extends Boots(dropLevel = 34)
case object EelskinBoots extends Boots(dropLevel = 39)
case object SharkskinBoots extends Boots(dropLevel = 44)
case object ShagreenBoots extends Boots(dropLevel = 55)
case object StealthBoots extends Boots(dropLevel = 62)
case object SlinkBoots extends Boots(dropLevel = 69)

//ES
case object WoolShoes extends Boots(dropLevel = 3)
case object VelvetSlippers extends Boots(dropLevel = 9)
case object SilkSlippers extends Boots(dropLevel = 22)
case object ScholarBoots extends Boots(dropLevel = 32)
case object SatinSlippers extends Boots(dropLevel = 38)
case object SamiteSlippers extends Boots(dropLevel = 44)
case object ConjurerBoots extends Boots(dropLevel = 53)
case object ArcanistSlippers extends Boots(dropLevel = 61)
case object SorcererBoots extends Boots(dropLevel = 67)

//Armour+Evasion
case object LeatherscaleBoots extends Boots(dropLevel = 6)
case object IronscaleBoots extends Boots(dropLevel = 18)
case object BronzescaleBoots extends Boots(dropLevel = 30)
case object SteelscaleBoots extends Boots(dropLevel = 36)
case object SerpentscaleBoots extends Boots(dropLevel = 42)
case object WyrmscaleBoots extends Boots(dropLevel = 51)
case object HydrascaleBoots extends Boots(dropLevel = 59)
case object DragonscaleBoots extends Boots(dropLevel = 65)
case object TwoTonedBoots extends Boots(dropLevel = 70) {
  override def baseType: BaseType = BaseType("Two-Toned Boots")
}

//Armour+ES
case object ChainBoots extends Boots(dropLevel = 5)
case object RingmailBoots extends Boots(dropLevel = 13)
case object MeshBoots extends Boots(dropLevel = 28)
case object RivetedBoots extends Boots(dropLevel = 36)
case object ZealotBoots extends Boots(dropLevel = 40)
case object SoldierBoots extends Boots(dropLevel = 49)
case object LegionBoots extends Boots(dropLevel = 58)
case object CrusaderBoots extends Boots(dropLevel = 64)

//Evasion+ES
case object WrappedBoots extends Boots(dropLevel = 6)
case object StrappedBoots extends Boots(dropLevel = 16)
case object ClaspedBoots extends Boots(dropLevel = 27)
case object ShackledBoots extends Boots(dropLevel = 34)
case object TrapperBoots extends Boots(dropLevel = 41)
case object AmbushBoots extends Boots(dropLevel = 47)
case object CarnalBoots extends Boots(dropLevel = 55)
case object AssassinsBoots extends Boots(dropLevel = 63) {
  override def baseType: BaseType = BaseType("Assassin's Boots")
}
case object MurderBoots extends Boots(dropLevel = 69)
