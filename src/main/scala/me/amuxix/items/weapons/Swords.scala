package me.amuxix.items.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Sword(dropLevel: Int, `class`: String) extends Item(dropLevel, `class` + " Sword")


sealed abstract class OneHandedSword(dropLevel: Int, `class`: String) extends Sword(dropLevel, `class` + "One Handed") {
  def this(dropLevel: Int) = this(dropLevel, "")
}

object RustedSword extends OneHandedSword(1)
object CopperSword extends OneHandedSword(5)
object Sabre extends OneHandedSword(10)
object BroadSword extends OneHandedSword(15)
object WarSword extends OneHandedSword(20)
object AncientSword extends OneHandedSword(24)
object ElegantSword extends OneHandedSword(28)
object DuskBlade extends OneHandedSword(32)
object HookSword extends OneHandedSword(34)
object VarisciteBlade extends OneHandedSword(35)
object Cutlass extends OneHandedSword(38)
object Baselard extends OneHandedSword(41)
object BattleSword extends OneHandedSword(44)
object ElderSword extends OneHandedSword(47)
object GracefulSword extends OneHandedSword(50)
object TwilightBlade extends OneHandedSword(53)
object Grappler extends OneHandedSword(55)
object GemstoneSword extends OneHandedSword(56)
object CorsairSword extends OneHandedSword(58)
object Gladius extends OneHandedSword(60)
object LegionSword extends OneHandedSword(62)
object VaalBlade extends OneHandedSword(64)
object EternalSword extends OneHandedSword(66)
object MidnightBlade extends OneHandedSword(68)
object TigerHook extends OneHandedSword(70)


sealed abstract class TwoHandedSword(dropLevel: Int) extends Sword(dropLevel, "Two Handed")

object CorrodedBlade extends TwoHandedSword(3)
object Longsword extends TwoHandedSword(8)
object BastardSword extends TwoHandedSword(12)
object TwoHandedSword extends TwoHandedSword(17) {
  override val baseType: BaseType = BaseType("Two-Handed Sword")
}
object EtchedGreatsword extends TwoHandedSword(22)
object OrnateSword extends TwoHandedSword(27)
object SpectralSword extends TwoHandedSword(32)
object CurvedBlade extends TwoHandedSword(35)
object ButcherSword extends TwoHandedSword(36)
object FootmanSword extends TwoHandedSword(40)
object HighlandBlade extends TwoHandedSword(44)
object EngravedGreatsword extends TwoHandedSword(48)
object TigerSword extends TwoHandedSword(51)
object WraithSword extends TwoHandedSword(54)
object LitheBlade extends TwoHandedSword(56)
object HeadmansSword extends TwoHandedSword(57) {
  override val baseType: BaseType = BaseType("Headman's Sword")
}
object ReaverSword extends TwoHandedSword(59)
object EzomyteBlade extends TwoHandedSword(61)
object VaalGreatsword extends TwoHandedSword(63)
object LionSword extends TwoHandedSword(65)
object InfernalSword extends TwoHandedSword(67)
object ExquisiteBlade extends TwoHandedSword(70)


sealed abstract class ThrustingOneHandedSword(dropLevel: Int) extends Sword(dropLevel, "Thrusting ")

object RustedSpike extends ThrustingOneHandedSword(3)
object WhaleboneRapier extends ThrustingOneHandedSword(7)
object BatteredFoil extends ThrustingOneHandedSword(12)
object BasketRapier extends ThrustingOneHandedSword(17)
object JaggedFoil extends ThrustingOneHandedSword(22)
object AntiqueRapier extends ThrustingOneHandedSword(26)
object ElegantFoil extends ThrustingOneHandedSword(30)
object ThornRapier extends ThrustingOneHandedSword(34)
object Smallsword extends ThrustingOneHandedSword(36)
object WyrmboneRapier extends ThrustingOneHandedSword(37)
object BurnishedFoil extends ThrustingOneHandedSword(40)
object Estoc extends ThrustingOneHandedSword(43)
object SerratedFoil extends ThrustingOneHandedSword(46)
object PrimevalRapier extends ThrustingOneHandedSword(49)
object FancyFoil extends ThrustingOneHandedSword(52)
object ApexRapier extends ThrustingOneHandedSword(55)
object CourtesanSword extends ThrustingOneHandedSword(57)
object DragonboneRapier extends ThrustingOneHandedSword(58)
object TemperedFoil extends ThrustingOneHandedSword(60)
object Pecoraro extends ThrustingOneHandedSword(62)
object SpiraledFoil extends ThrustingOneHandedSword(64)
object VaalRapier extends ThrustingOneHandedSword(66)
object JewelledFoil extends ThrustingOneHandedSword(68)
object HarpyRapier extends ThrustingOneHandedSword(70)
object DragoonSword extends ThrustingOneHandedSword(72)