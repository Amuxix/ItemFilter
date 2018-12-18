package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Armour

sealed abstract class Helmet(dropLevel: Int) extends Armour(2, 2, dropLevel, "Helmet")

object Helmet extends FilterClass[Helmet] {
  // format: off
  val armourHelmets: Seq[Helmet] = Seq(IronHat, ConeHelmet, BarbuteHelmet, CloseHelmet, GladiatorHelmet, ReaverHelmet, SiegeHelmet, SamiteHelmet, EzomyteBurgonet, RoyalBurgonet, EternalBurgonet)
  val evasionHelmets: Seq[Helmet] = Seq(LeatherCap, Tricorne, LeatherHood, WolfPelt, HunterHood, NobleTricorne, UrsinePelt, SilkenHood, SinnerTricorne, LionPelt)
  val energyShieldHelmets: Seq[Helmet] = Seq(VineCirclet, IronCirclet, TortureCage, TribalCirclet, BoneCirclet, LunarisCirclet, SteelCirclet, NecromancerCirclet, SolarisCirclet, MindCage, HubrisCirclet)
  val armourEvasionHelmets: Seq[Helmet] = Seq(BatteredHelm, Sallet, VisoredSallet, GildedSallet, SecutorHelm, FencerHelm, LacqueredHelmet, FlutedBascinet, PigFacedBascinet, NightmareBascinet)
  val armourEnergyShieldHelmets: Seq[Helmet] = Seq(RustedCoif, SoldierHelmet, GreatHelmet, CrusaderHelmet, AventailHelmet, ZealotHelmet, GreatCrown, MagistrateCrown, ProphetCrown, PraetorCrown, BoneHelmet)
  val evasionEnergyShieldHelmets: Seq[Helmet] = Seq(ScareMask, PlagueMask, IronMask, FestivalMask, GoldenMask, RavenMask, CallousMask, RegicideMask, HarlequinMask, VaalMask, DeicideMask)
  val helmets: Seq[Seq[Helmet]] = Seq(armourHelmets, evasionHelmets, energyShieldHelmets, armourEvasionHelmets, armourEnergyShieldHelmets, evasionEnergyShieldHelmets)
  // format: on
  override val all: Seq[Helmet] = helmets.flatten
}

//Armour
case object IronHat extends Helmet(dropLevel = 1)
case object ConeHelmet extends Helmet(dropLevel = 7)
case object BarbuteHelmet extends Helmet(dropLevel = 18)
case object CloseHelmet extends Helmet(dropLevel = 26)
case object GladiatorHelmet extends Helmet(dropLevel = 35)
case object ReaverHelmet extends Helmet(dropLevel = 40)
case object SiegeHelmet extends Helmet(dropLevel = 48)
case object SamiteHelmet extends Helmet(dropLevel = 55)
case object EzomyteBurgonet extends Helmet(dropLevel = 60)
case object RoyalBurgonet extends Helmet(dropLevel = 65)
case object EternalBurgonet extends Helmet(dropLevel = 69)

//Evasion
case object LeatherCap extends Helmet(dropLevel = 3)
case object Tricorne extends Helmet(dropLevel = 10)
case object LeatherHood extends Helmet(dropLevel = 20)
case object WolfPelt extends Helmet(dropLevel = 30)
case object HunterHood extends Helmet(dropLevel = 41)
case object NobleTricorne extends Helmet(dropLevel = 47)
case object UrsinePelt extends Helmet(dropLevel = 55)
case object SilkenHood extends Helmet(dropLevel = 60)
case object SinnerTricorne extends Helmet(dropLevel = 64)
case object LionPelt extends Helmet(dropLevel = 70)

//ES
case object VineCirclet extends Helmet(dropLevel = 3)
case object IronCirclet extends Helmet(dropLevel = 8)
case object TortureCage extends Helmet(dropLevel = 17)
case object TribalCirclet extends Helmet(dropLevel = 26)
case object BoneCirclet extends Helmet(dropLevel = 34)
case object LunarisCirclet extends Helmet(dropLevel = 39)
case object SteelCirclet extends Helmet(dropLevel = 48)
case object NecromancerCirclet extends Helmet(dropLevel = 54)
case object SolarisCirclet extends Helmet(dropLevel = 59)
case object MindCage extends Helmet(dropLevel = 65)
case object HubrisCirclet extends Helmet(dropLevel = 69)

//Armour+Evasion
case object BatteredHelm extends Helmet(dropLevel = 4)
case object Sallet extends Helmet(dropLevel = 13)
case object VisoredSallet extends Helmet(dropLevel = 23)
case object GildedSallet extends Helmet(dropLevel = 33)
case object SecutorHelm extends Helmet(dropLevel = 36)
case object FencerHelm extends Helmet(dropLevel = 43)
case object LacqueredHelmet extends Helmet(dropLevel = 51)
case object FlutedBascinet extends Helmet(dropLevel = 58)
case object PigFacedBascinet extends Helmet(dropLevel = 63) {
  override def baseType: BaseType = BaseType("Pig-Faced Bascinet")
}
case object NightmareBascinet extends Helmet(dropLevel = 67)

//Armour+ES
case object RustedCoif extends Helmet(dropLevel = 5)
case object SoldierHelmet extends Helmet(dropLevel = 12)
case object GreatHelmet extends Helmet(dropLevel = 22)
case object CrusaderHelmet extends Helmet(dropLevel = 31)
case object AventailHelmet extends Helmet(dropLevel = 37)
case object ZealotHelmet extends Helmet(dropLevel = 44)
case object GreatCrown extends Helmet(dropLevel = 53)
case object MagistrateCrown extends Helmet(dropLevel = 58)
case object ProphetCrown extends Helmet(dropLevel = 63)
case object PraetorCrown extends Helmet(dropLevel = 68)
case object BoneHelmet extends Helmet(dropLevel = 73)

//Evasion+ES
case object ScareMask extends Helmet(dropLevel = 4)
case object PlagueMask extends Helmet(dropLevel = 10)
case object IronMask extends Helmet(dropLevel = 17)
case object FestivalMask extends Helmet(dropLevel = 28)
case object GoldenMask extends Helmet(dropLevel = 35)
case object RavenMask extends Helmet(dropLevel = 38)
case object CallousMask extends Helmet(dropLevel = 45)
case object RegicideMask extends Helmet(dropLevel = 52)
case object HarlequinMask extends Helmet(dropLevel = 57)
case object VaalMask extends Helmet(dropLevel = 62)
case object DeicideMask extends Helmet(dropLevel = 67)
