package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Sword(height: Int, width: Int, dropLevel: Int, `class`: String) extends Weapon(height, width, dropLevel, `class` + "Sword")

sealed abstract class OneHandedSword(dropLevel: Int) extends Sword(3, 2, dropLevel, "One Handed ")

object OneHandedSword extends FilterClass[OneHandedSword] {
  override val all: Seq[OneHandedSword] = Seq(RustedSword, CopperSword, Sabre, BroadSword, WarSword, AncientSword, ElegantSword, DuskBlade, HookSword, VarisciteBlade, Cutlass, Baselard, BattleSword, ElderSword, GracefulSword, TwilightBlade, Grappler, GemstoneSword, CorsairSword, Gladius, LegionSword, VaalBlade, EternalSword, MidnightBlade, TigerHook)
}

case object RustedSword extends OneHandedSword(dropLevel = 1)
case object CopperSword extends OneHandedSword(dropLevel = 5)
case object Sabre extends OneHandedSword(dropLevel = 10)
case object BroadSword extends OneHandedSword(dropLevel = 15)
case object WarSword extends OneHandedSword(dropLevel = 20)
case object AncientSword extends OneHandedSword(dropLevel = 24)
case object ElegantSword extends OneHandedSword(dropLevel = 28)
case object DuskBlade extends OneHandedSword(dropLevel = 32)
case object HookSword extends OneHandedSword(dropLevel = 34)
case object VarisciteBlade extends OneHandedSword(dropLevel = 35)
case object Cutlass extends OneHandedSword(dropLevel = 38)
case object Baselard extends OneHandedSword(dropLevel = 41)
case object BattleSword extends OneHandedSword(dropLevel = 44)
case object ElderSword extends OneHandedSword(dropLevel = 47)
case object GracefulSword extends OneHandedSword(dropLevel = 50)
case object TwilightBlade extends OneHandedSword(dropLevel = 53)
case object Grappler extends OneHandedSword(dropLevel = 55)
case object GemstoneSword extends OneHandedSword(dropLevel = 56)
case object CorsairSword extends OneHandedSword(dropLevel = 58)
case object Gladius extends OneHandedSword(dropLevel = 60)
case object LegionSword extends OneHandedSword(dropLevel = 62)
case object VaalBlade extends OneHandedSword(dropLevel = 64)
case object EternalSword extends OneHandedSword(dropLevel = 66)
case object MidnightBlade extends OneHandedSword(dropLevel = 68)
case object TigerHook extends OneHandedSword(dropLevel = 70)

sealed abstract class TwoHandedSword(dropLevel: Int) extends Sword(4, 2, dropLevel, "Two Handed ")

object TwoHandedSword extends FilterClass[TwoHandedSword] {
  override val all: Seq[TwoHandedSword] = Seq(CorrodedBlade, Longsword, BastardSword, `Two-HandedSword`, EtchedGreatsword, OrnateSword, SpectralSword, CurvedBlade, ButcherSword, FootmanSword, HighlandBlade, EngravedGreatsword, TigerSword, WraithSword, LitheBlade, HeadmansSword, ReaverSword, EzomyteBlade, VaalGreatsword, LionSword, InfernalSword, ExquisiteBlade)
}

case object CorrodedBlade extends TwoHandedSword(dropLevel = 3)
case object Longsword extends TwoHandedSword(dropLevel = 8)
case object BastardSword extends TwoHandedSword(dropLevel = 12)
case object `Two-HandedSword` extends TwoHandedSword(dropLevel = 17) {
  override def baseType: BaseType = BaseType("Two-Handed Sword")
}
case object EtchedGreatsword extends TwoHandedSword(dropLevel = 22)
case object OrnateSword extends TwoHandedSword(dropLevel = 27)
case object SpectralSword extends TwoHandedSword(dropLevel = 32)
case object CurvedBlade extends TwoHandedSword(dropLevel = 35)
case object ButcherSword extends TwoHandedSword(dropLevel = 36)
case object FootmanSword extends TwoHandedSword(dropLevel = 40)
case object HighlandBlade extends TwoHandedSword(dropLevel = 44)
case object EngravedGreatsword extends TwoHandedSword(dropLevel = 48)
case object TigerSword extends TwoHandedSword(dropLevel = 51)
case object WraithSword extends TwoHandedSword(dropLevel = 54)
case object LitheBlade extends TwoHandedSword(dropLevel = 56)
case object HeadmansSword extends TwoHandedSword(dropLevel = 57) {
  override def baseType: BaseType = BaseType("Headman's Sword")
}
case object ReaverSword extends TwoHandedSword(dropLevel = 59)
case object EzomyteBlade extends TwoHandedSword(dropLevel = 61)
case object VaalGreatsword extends TwoHandedSword(dropLevel = 63)
case object LionSword extends TwoHandedSword(dropLevel = 65)
case object InfernalSword extends TwoHandedSword(dropLevel = 67)
case object ExquisiteBlade extends TwoHandedSword(dropLevel = 70)

sealed abstract class ThrustingOneHandedSword(dropLevel: Int) extends Sword(4, 1, dropLevel, "Thrusting One Hand ")

object ThrustingOneHandedSword extends FilterClass[ThrustingOneHandedSword] {
  override val all: Seq[ThrustingOneHandedSword] = Seq(RustedSpike, WhaleboneRapier, BatteredFoil, BasketRapier, JaggedFoil, AntiqueRapier, ElegantFoil, ThornRapier, Smallsword, WyrmboneRapier, BurnishedFoil, Estoc, SerratedFoil, PrimevalRapier, FancyFoil, ApexRapier, CourtesanSword, DragonboneRapier, TemperedFoil, Pecoraro, SpiraledFoil, VaalRapier, JewelledFoil, HarpyRapier, DragoonSword)
}

case object RustedSpike extends ThrustingOneHandedSword(dropLevel = 3)
case object WhaleboneRapier extends ThrustingOneHandedSword(dropLevel = 7)
case object BatteredFoil extends ThrustingOneHandedSword(dropLevel = 12)
case object BasketRapier extends ThrustingOneHandedSword(dropLevel = 17)
case object JaggedFoil extends ThrustingOneHandedSword(dropLevel = 22)
case object AntiqueRapier extends ThrustingOneHandedSword(dropLevel = 26)
case object ElegantFoil extends ThrustingOneHandedSword(dropLevel = 30)
case object ThornRapier extends ThrustingOneHandedSword(dropLevel = 34)
case object Smallsword extends ThrustingOneHandedSword(dropLevel = 36)
case object WyrmboneRapier extends ThrustingOneHandedSword(dropLevel = 37)
case object BurnishedFoil extends ThrustingOneHandedSword(dropLevel = 40)
case object Estoc extends ThrustingOneHandedSword(dropLevel = 43)
case object SerratedFoil extends ThrustingOneHandedSword(dropLevel = 46)
case object PrimevalRapier extends ThrustingOneHandedSword(dropLevel = 49)
case object FancyFoil extends ThrustingOneHandedSword(dropLevel = 52)
case object ApexRapier extends ThrustingOneHandedSword(dropLevel = 55)
case object CourtesanSword extends ThrustingOneHandedSword(dropLevel = 57)
case object DragonboneRapier extends ThrustingOneHandedSword(dropLevel = 58)
case object TemperedFoil extends ThrustingOneHandedSword(dropLevel = 60)
case object Pecoraro extends ThrustingOneHandedSword(dropLevel = 62)
case object SpiraledFoil extends ThrustingOneHandedSword(dropLevel = 64)
case object VaalRapier extends ThrustingOneHandedSword(dropLevel = 66)
case object JewelledFoil extends ThrustingOneHandedSword(dropLevel = 68)
case object HarpyRapier extends ThrustingOneHandedSword(dropLevel = 70)
case object DragoonSword extends ThrustingOneHandedSword(dropLevel = 72)
