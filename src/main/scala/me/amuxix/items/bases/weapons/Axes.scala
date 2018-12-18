package me.amuxix.items.bases.weapons
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Axe(height: Int, width: Int, dropLevel: Int, `class`: String) extends Weapon(height, width, dropLevel, `class` + " Axe")

sealed abstract class OneHandedAxe(dropLevel: Int) extends Axe(3, 2, dropLevel, "Two Handed")

object OneHandedAxe extends FilterClass[OneHandedAxe] {
  override val all: Seq[OneHandedAxe] = Seq(RustedHatchet, JadeHatchet, BoardingAxe, Cleaver, BroadAxe, ArmingAxe, DecorativeAxe, SpectralAxe, EtchedHatchet, JasperAxe, Tomahawk, WristChopper, WarAxe, ChestSplitter, CeremonialAxe, WraithAxe, EngravedHatchet, KaruiAxe, SiegeAxe, ReaverAxe, ButcherAxe, VaalHatchet, RoyalAxe, InfernalAxe, RunicHatchet)
}

case object RustedHatchet extends OneHandedAxe(dropLevel = 2)
case object JadeHatchet extends OneHandedAxe(dropLevel = 6)
case object BoardingAxe extends OneHandedAxe(dropLevel = 11)
case object Cleaver extends OneHandedAxe(dropLevel = 16)
case object BroadAxe extends OneHandedAxe(dropLevel = 21)
case object ArmingAxe extends OneHandedAxe(dropLevel = 25)
case object DecorativeAxe extends OneHandedAxe(dropLevel = 29)
case object SpectralAxe extends OneHandedAxe(dropLevel = 33)
case object EtchedHatchet extends OneHandedAxe(dropLevel = 35)
case object JasperAxe extends OneHandedAxe(dropLevel = 36)
case object Tomahawk extends OneHandedAxe(dropLevel = 39)
case object WristChopper extends OneHandedAxe(dropLevel = 42)
case object WarAxe extends OneHandedAxe(dropLevel = 45)
case object ChestSplitter extends OneHandedAxe(dropLevel = 48)
case object CeremonialAxe extends OneHandedAxe(dropLevel = 51)
case object WraithAxe extends OneHandedAxe(dropLevel = 54)
case object EngravedHatchet extends OneHandedAxe(dropLevel = 56)
case object KaruiAxe extends OneHandedAxe(dropLevel = 57)
case object SiegeAxe extends OneHandedAxe(dropLevel = 59)
case object ReaverAxe extends OneHandedAxe(dropLevel = 61)
case object ButcherAxe extends OneHandedAxe(dropLevel = 63)
case object VaalHatchet extends OneHandedAxe(dropLevel = 65)
case object RoyalAxe extends OneHandedAxe(dropLevel = 67)
case object InfernalAxe extends OneHandedAxe(dropLevel = 69)
case object RunicHatchet extends OneHandedAxe(dropLevel = 71)

sealed abstract class TwoHandedAxe(dropLevel: Int) extends Axe(4, 2, dropLevel, "Two Handed")

object TwoHandedAxe extends FilterClass[TwoHandedAxe] {
  override val all: Seq[TwoHandedAxe] = Seq(StoneAxe, JadeChopper, Woodsplitter, Poleaxe, DoubleAxe, GildedAxe, ShadowAxe, DaggerAxe, JasperChopper, TimberAxe, HeadsmanAxe, Labrys, NobleAxe, AbyssalAxe, KaruiChopper, TalonAxe, SunderingAxe, EzomyteAxe, VaalAxe, DespotAxe, VoidAxe, Fleshripper)
}

case object StoneAxe extends TwoHandedAxe(dropLevel = 4)
case object JadeChopper extends TwoHandedAxe(dropLevel = 9)
case object Woodsplitter extends TwoHandedAxe(dropLevel = 13)
case object Poleaxe extends TwoHandedAxe(dropLevel = 18)
case object DoubleAxe extends TwoHandedAxe(dropLevel = 23)
case object GildedAxe extends TwoHandedAxe(dropLevel = 28)
case object ShadowAxe extends TwoHandedAxe(dropLevel = 33)
case object DaggerAxe extends TwoHandedAxe(dropLevel = 36)
case object JasperChopper extends TwoHandedAxe(dropLevel = 37)
case object TimberAxe extends TwoHandedAxe(dropLevel = 41)
case object HeadsmanAxe extends TwoHandedAxe(dropLevel = 45)
case object Labrys extends TwoHandedAxe(dropLevel = 49)
case object NobleAxe extends TwoHandedAxe(dropLevel = 52)
case object AbyssalAxe extends TwoHandedAxe(dropLevel = 55)
case object KaruiChopper extends TwoHandedAxe(dropLevel = 58)
case object TalonAxe extends TwoHandedAxe(dropLevel = 59)
case object SunderingAxe extends TwoHandedAxe(dropLevel = 60)
case object EzomyteAxe extends TwoHandedAxe(dropLevel = 62)
case object VaalAxe extends TwoHandedAxe(dropLevel = 64)
case object DespotAxe extends TwoHandedAxe(dropLevel = 66)
case object VoidAxe extends TwoHandedAxe(dropLevel = 68)
case object Fleshripper extends TwoHandedAxe(dropLevel = 70)
