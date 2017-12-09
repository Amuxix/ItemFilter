package me.amuxix.items.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Weapon

sealed abstract class Sword(dropLevel: Int, `class`: String) extends Weapon(dropLevel, `class` + " Sword")


sealed abstract class OneHandedSword(dropLevel: Int, `class`: String) extends Sword(dropLevel, `class` + "One Handed") {
  def this(dropLevel: Int) = this(dropLevel, "")
}

object RustedSword extends OneHandedSword(dropLevel = 1)
object CopperSword extends OneHandedSword(dropLevel = 5)
object Sabre extends OneHandedSword(dropLevel = 10)
object BroadSword extends OneHandedSword(dropLevel = 15)
object WarSword extends OneHandedSword(dropLevel = 20)
object AncientSword extends OneHandedSword(dropLevel = 24)
object ElegantSword extends OneHandedSword(dropLevel = 28)
object DuskBlade extends OneHandedSword(dropLevel = 32)
object HookSword extends OneHandedSword(dropLevel = 34)
object VarisciteBlade extends OneHandedSword(dropLevel = 35)
object Cutlass extends OneHandedSword(dropLevel = 38)
object Baselard extends OneHandedSword(dropLevel = 41)
object BattleSword extends OneHandedSword(dropLevel = 44)
object ElderSword extends OneHandedSword(dropLevel = 47)
object GracefulSword extends OneHandedSword(dropLevel = 50)
object TwilightBlade extends OneHandedSword(dropLevel = 53)
object Grappler extends OneHandedSword(dropLevel = 55)
object GemstoneSword extends OneHandedSword(dropLevel = 56)
object CorsairSword extends OneHandedSword(dropLevel = 58)
object Gladius extends OneHandedSword(dropLevel = 60)
object LegionSword extends OneHandedSword(dropLevel = 62)
object VaalBlade extends OneHandedSword(dropLevel = 64)
object EternalSword extends OneHandedSword(dropLevel = 66)
object MidnightBlade extends OneHandedSword(dropLevel = 68)
object TigerHook extends OneHandedSword(dropLevel = 70)


sealed abstract class TwoHandedSword(dropLevel: Int) extends Sword(dropLevel, "Two Handed")

object CorrodedBlade extends TwoHandedSword(dropLevel = 3)
object Longsword extends TwoHandedSword(dropLevel = 8)
object BastardSword extends TwoHandedSword(dropLevel = 12)
object TwoHandedSword extends TwoHandedSword(dropLevel = 17) {
  override val baseType: BaseType = BaseType("Two-Handed Sword")
}
object EtchedGreatsword extends TwoHandedSword(dropLevel = 22)
object OrnateSword extends TwoHandedSword(dropLevel = 27)
object SpectralSword extends TwoHandedSword(dropLevel = 32)
object CurvedBlade extends TwoHandedSword(dropLevel = 35)
object ButcherSword extends TwoHandedSword(dropLevel = 36)
object FootmanSword extends TwoHandedSword(dropLevel = 40)
object HighlandBlade extends TwoHandedSword(dropLevel = 44)
object EngravedGreatsword extends TwoHandedSword(dropLevel = 48)
object TigerSword extends TwoHandedSword(dropLevel = 51)
object WraithSword extends TwoHandedSword(dropLevel = 54)
object LitheBlade extends TwoHandedSword(dropLevel = 56)
object HeadmansSword extends TwoHandedSword(dropLevel = 57) {
  override val baseType: BaseType = BaseType("Headman's Sword")
}
object ReaverSword extends TwoHandedSword(dropLevel = 59)
object EzomyteBlade extends TwoHandedSword(dropLevel = 61)
object VaalGreatsword extends TwoHandedSword(dropLevel = 63)
object LionSword extends TwoHandedSword(dropLevel = 65)
object InfernalSword extends TwoHandedSword(dropLevel = 67)
object ExquisiteBlade extends TwoHandedSword(dropLevel = 70)


sealed abstract class ThrustingOneHandedSword(dropLevel: Int) extends Sword(dropLevel, "Thrusting ")

object RustedSpike extends ThrustingOneHandedSword(dropLevel = 3)
object WhaleboneRapier extends ThrustingOneHandedSword(dropLevel = 7)
object BatteredFoil extends ThrustingOneHandedSword(dropLevel = 12)
object BasketRapier extends ThrustingOneHandedSword(dropLevel = 17)
object JaggedFoil extends ThrustingOneHandedSword(dropLevel = 22)
object AntiqueRapier extends ThrustingOneHandedSword(dropLevel = 26)
object ElegantFoil extends ThrustingOneHandedSword(dropLevel = 30)
object ThornRapier extends ThrustingOneHandedSword(dropLevel = 34)
object Smallsword extends ThrustingOneHandedSword(dropLevel = 36)
object WyrmboneRapier extends ThrustingOneHandedSword(dropLevel = 37)
object BurnishedFoil extends ThrustingOneHandedSword(dropLevel = 40)
object Estoc extends ThrustingOneHandedSword(dropLevel = 43)
object SerratedFoil extends ThrustingOneHandedSword(dropLevel = 46)
object PrimevalRapier extends ThrustingOneHandedSword(dropLevel = 49)
object FancyFoil extends ThrustingOneHandedSword(dropLevel = 52)
object ApexRapier extends ThrustingOneHandedSword(dropLevel = 55)
object CourtesanSword extends ThrustingOneHandedSword(dropLevel = 57)
object DragonboneRapier extends ThrustingOneHandedSword(dropLevel = 58)
object TemperedFoil extends ThrustingOneHandedSword(dropLevel = 60)
object Pecoraro extends ThrustingOneHandedSword(dropLevel = 62)
object SpiraledFoil extends ThrustingOneHandedSword(dropLevel = 64)
object VaalRapier extends ThrustingOneHandedSword(dropLevel = 66)
object JewelledFoil extends ThrustingOneHandedSword(dropLevel = 68)
object HarpyRapier extends ThrustingOneHandedSword(dropLevel = 70)
object DragoonSword extends ThrustingOneHandedSword(dropLevel = 72)