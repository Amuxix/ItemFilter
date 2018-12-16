package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Armour

sealed abstract class Gloves(dropLevel: Int) extends Armour(2, 2, dropLevel, "Gloves")

object Gloves extends FilterClass[Gloves] {
  // format: off
  val armourGloves: Seq[Gloves] = Seq(IronGauntlets, PlatedGauntlets, BronzeGauntlets, SteelGauntlets, AntiqueGauntlets, AncientGauntlets, GoliathGauntlets, VaalGauntlets, TitanGauntlets, SpikedGloves)
  val evasionGloves: Seq[Gloves] = Seq(RawhideGloves, GoathideGloves, DeerskinGloves, NubuckGloves, EelskinGloves, SharkskinGloves, ShagreenGloves, StealthGloves, SlinkGloves, GrippedGloves)
  val energyShieldGloves: Seq[Gloves] = Seq(WoolGloves, VelvetGloves, SilkGloves, EmbroideredGloves, SatinGloves, SamiteGloves, ConjurerGloves, ArcanistGloves, SorcererGloves, FingerlessSilkGloves)
  val armourEvasionGloves: Seq[Gloves] = Seq(FishscaleGauntlets, IronscaleGauntlets, BronzescaleGauntlets, SteelscaleGauntlets, SerpentscaleGauntlets, WyrmscaleGauntlets, HydrascaleGauntlets, DragonscaleGauntlets)
  val armourEnergyShieldGloves: Seq[Gloves] = Seq(ChainGloves, RingmailGloves, MeshGloves, RivetedGloves, ZealotGloves, SoldierGloves, LegionGloves, CrusaderGloves)
  val evasionEnergyShieldGloves: Seq[Gloves] = Seq(WrappedMitts, StrappedMitts, ClaspedMitts, TrapperMitts, AmbushMitts, CarnalMitts, AssassinsMitts, MurderMitts)
  val gloves: Seq[Seq[Gloves]] = Seq(armourGloves, evasionGloves, energyShieldGloves, armourEvasionGloves, armourEnergyShieldGloves, evasionEnergyShieldGloves)
  // format: on

  override val all: Seq[Gloves] = gloves.flatten
}

//Armour
case object IronGauntlets extends Gloves(dropLevel = 1)
case object PlatedGauntlets extends Gloves(dropLevel = 11)
case object BronzeGauntlets extends Gloves(dropLevel = 23)
case object SteelGauntlets extends Gloves(dropLevel = 35)
case object AntiqueGauntlets extends Gloves(dropLevel = 39)
case object AncientGauntlets extends Gloves(dropLevel = 47)
case object GoliathGauntlets extends Gloves(dropLevel = 53)
case object VaalGauntlets extends Gloves(dropLevel = 63)
case object TitanGauntlets extends Gloves(dropLevel = 69)
case object SpikedGloves extends Gloves(dropLevel = 70)

//Evasion
case object RawhideGloves extends Gloves(dropLevel = 3)
case object GoathideGloves extends Gloves(dropLevel = 9)
case object DeerskinGloves extends Gloves(dropLevel = 21)
case object NubuckGloves extends Gloves(dropLevel = 33)
case object EelskinGloves extends Gloves(dropLevel = 38)
case object SharkskinGloves extends Gloves(dropLevel = 45)
case object ShagreenGloves extends Gloves(dropLevel = 54)
case object StealthGloves extends Gloves(dropLevel = 62)
case object SlinkGloves extends Gloves(dropLevel = 70)
case object GrippedGloves extends Gloves(dropLevel = 70)

//ES
case object WoolGloves extends Gloves(dropLevel = 3)
case object VelvetGloves extends Gloves(dropLevel = 12)
case object SilkGloves extends Gloves(dropLevel = 25)
case object EmbroideredGloves extends Gloves(dropLevel = 36)
case object SatinGloves extends Gloves(dropLevel = 41)
case object SamiteGloves extends Gloves(dropLevel = 47)
case object ConjurerGloves extends Gloves(dropLevel = 55)
case object ArcanistGloves extends Gloves(dropLevel = 60)
case object SorcererGloves extends Gloves(dropLevel = 69)
case object FingerlessSilkGloves extends Gloves(dropLevel = 70)

//Armour+Evasion
case object FishscaleGauntlets extends Gloves(dropLevel = 4)
case object IronscaleGauntlets extends Gloves(dropLevel = 15)
case object BronzescaleGauntlets extends Gloves(dropLevel = 27)
case object SteelscaleGauntlets extends Gloves(dropLevel = 36)
case object SerpentscaleGauntlets extends Gloves(dropLevel = 43)
case object WyrmscaleGauntlets extends Gloves(dropLevel = 49)
case object HydrascaleGauntlets extends Gloves(dropLevel = 59)
case object DragonscaleGauntlets extends Gloves(dropLevel = 67)

//Armour+ES
case object ChainGloves extends Gloves(dropLevel = 7)
case object RingmailGloves extends Gloves(dropLevel = 19)
case object MeshGloves extends Gloves(dropLevel = 32)
case object RivetedGloves extends Gloves(dropLevel = 37)
case object ZealotGloves extends Gloves(dropLevel = 43)
case object SoldierGloves extends Gloves(dropLevel = 51)
case object LegionGloves extends Gloves(dropLevel = 57)
case object CrusaderGloves extends Gloves(dropLevel = 66)

//Evasion+ES
case object WrappedMitts extends Gloves(dropLevel = 5)
case object StrappedMitts extends Gloves(dropLevel = 16)
case object ClaspedMitts extends Gloves(dropLevel = 31)
case object TrapperMitts extends Gloves(dropLevel = 36)
case object AmbushMitts extends Gloves(dropLevel = 45)
case object CarnalMitts extends Gloves(dropLevel = 50)
case object AssassinsMitts extends Gloves(dropLevel = 58) {
  override def baseType: BaseType = BaseType("Assassin's Mitts")
}
case object MurderMitts extends Gloves(dropLevel = 67)
