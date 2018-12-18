package me.amuxix.items.bases.weapons
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Bow(dropLevel: Int) extends Weapon(4, 2, dropLevel, "Bow")

object Bow extends FilterClass[Bow] {
  override val all: Seq[Bow] = Seq(CrudeBow, ShortBow, LongBow, CompositeBow, RecurveBow, BoneBow, RoyalBow, DeathBow, GroveBow, ReflexBow, DecurveBow, CompoundBow, SniperBow, IvoryBow, HighbornBow, DecimationBow, ThicketBow, SteelwoodBow, CitadelBow, RangerBow, AssassinBow, SpineBow, ImperialBow, HarbingerBow, MarakethBow)
}

case object CrudeBow extends Bow(dropLevel = 1)
case object ShortBow extends Bow(dropLevel = 5)
case object LongBow extends Bow(dropLevel = 9)
case object CompositeBow extends Bow(dropLevel = 14)
case object RecurveBow extends Bow(dropLevel = 18)
case object BoneBow extends Bow(dropLevel = 23)
case object RoyalBow extends Bow(dropLevel = 28)
case object DeathBow extends Bow(dropLevel = 32)
case object GroveBow extends Bow(dropLevel = 35)
case object ReflexBow extends Bow(dropLevel = 36)
case object DecurveBow extends Bow(dropLevel = 38)
case object CompoundBow extends Bow(dropLevel = 41)
case object SniperBow extends Bow(dropLevel = 44)
case object IvoryBow extends Bow(dropLevel = 47)
case object HighbornBow extends Bow(dropLevel = 50)
case object DecimationBow extends Bow(dropLevel = 53)
case object ThicketBow extends Bow(dropLevel = 56)
case object SteelwoodBow extends Bow(dropLevel = 57)
case object CitadelBow extends Bow(dropLevel = 58)
case object RangerBow extends Bow(dropLevel = 60)
case object AssassinBow extends Bow(dropLevel = 62)
case object SpineBow extends Bow(dropLevel = 64)
case object ImperialBow extends Bow(dropLevel = 66)
case object HarbingerBow extends Bow(dropLevel = 68)
case object MarakethBow extends Bow(dropLevel = 71)
