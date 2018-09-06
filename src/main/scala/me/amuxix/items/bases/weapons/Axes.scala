package me.amuxix.items.bases.weapons

import me.amuxix.items.Size
import me.amuxix.items.bases.Weapon

sealed abstract class Axe(size: Size, dropLevel: Int, `class`: String) extends Weapon(size, dropLevel, `class` + " Axe")

sealed abstract class OneHandedAxe(dropLevel: Int) extends Axe(Size(3, 2), dropLevel, "Two Handed")

object RustedHatchet extends OneHandedAxe(dropLevel = 2)
object JadeHatchet extends OneHandedAxe(dropLevel = 6)
object BoardingAxe extends OneHandedAxe(dropLevel = 11)
object Cleaver extends OneHandedAxe(dropLevel = 16)
object BroadAxe extends OneHandedAxe(dropLevel = 21)
object ArmingAxe extends OneHandedAxe(dropLevel = 25)
object DecorativeAxe extends OneHandedAxe(dropLevel = 29)
object SpectralAxe extends OneHandedAxe(dropLevel = 33)
object EtchedHatchet extends OneHandedAxe(dropLevel = 35)
object JasperAxe extends OneHandedAxe(dropLevel = 36)
object Tomahawk extends OneHandedAxe(dropLevel = 39)
object WristChopper extends OneHandedAxe(dropLevel = 42)
object WarAxe extends OneHandedAxe(dropLevel = 45)
object ChestSplitter extends OneHandedAxe(dropLevel = 48)
object CeremonialAxe extends OneHandedAxe(dropLevel = 51)
object WraithAxe extends OneHandedAxe(dropLevel = 54)
object EngravedHatchet extends OneHandedAxe(dropLevel = 56)
object KaruiAxe extends OneHandedAxe(dropLevel = 57)
object SiegeAxe extends OneHandedAxe(dropLevel = 59)
object ReaverAxe extends OneHandedAxe(dropLevel = 61)
object ButcherAxe extends OneHandedAxe(dropLevel = 63)
object VaalHatchet extends OneHandedAxe(dropLevel = 65)
object RoyalAxe extends OneHandedAxe(dropLevel = 67)
object InfernalAxe extends OneHandedAxe(dropLevel = 69)
object RunicHatchet extends OneHandedAxe(dropLevel = 71)

sealed abstract class TwoHandedAxe(dropLevel: Int) extends Axe(Size(4, 2), dropLevel, "Two Handed")

object StoneAxe extends TwoHandedAxe(dropLevel = 4)
object JadeChopper extends TwoHandedAxe(dropLevel = 9)
object Woodsplitter extends TwoHandedAxe(dropLevel = 13)
object Poleaxe extends TwoHandedAxe(dropLevel = 18)
object DoubleAxe extends TwoHandedAxe(dropLevel = 23)
object GildedAxe extends TwoHandedAxe(dropLevel = 28)
object ShadowAxe extends TwoHandedAxe(dropLevel = 33)
object DaggerAxe extends TwoHandedAxe(dropLevel = 36)
object JasperChopper extends TwoHandedAxe(dropLevel = 37)
object TimberAxe extends TwoHandedAxe(dropLevel = 41)
object HeadsmanAxe extends TwoHandedAxe(dropLevel = 45)
object Labrys extends TwoHandedAxe(dropLevel = 49)
object NobleAxe extends TwoHandedAxe(dropLevel = 52)
object AbyssalAxe extends TwoHandedAxe(dropLevel = 55)
object KaruiChopper extends TwoHandedAxe(dropLevel = 58)
object TalonAxe extends TwoHandedAxe(dropLevel = 59)
object SunderingAxe extends TwoHandedAxe(dropLevel = 60)
object EzomyteAxe extends TwoHandedAxe(dropLevel = 62)
object VaalAxe extends TwoHandedAxe(dropLevel = 64)
object DespotAxe extends TwoHandedAxe(dropLevel = 66)
object VoidAxe extends TwoHandedAxe(dropLevel = 68)
object Fleshripper extends TwoHandedAxe(dropLevel = 70)
