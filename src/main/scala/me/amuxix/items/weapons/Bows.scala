package me.amuxix.items.weapons

import me.amuxix.items.Weapon

sealed abstract class Bow(dropLevel: Int) extends Weapon(dropLevel, "Bow")

object CrudeBow extends Bow(dropLevel = 1)
object ShortBow extends Bow(dropLevel = 5)
object LongBow extends Bow(dropLevel = 9)
object CompositeBow extends Bow(dropLevel = 14)
object RecurveBow extends Bow(dropLevel = 18)
object BoneBow extends Bow(dropLevel = 23)
object RoyalBow extends Bow(dropLevel = 28)
object DeathBow extends Bow(dropLevel = 32)
object GroveBow extends Bow(dropLevel = 35)
object ReflexBow extends Bow(dropLevel = 36)
object DecurveBow extends Bow(dropLevel = 38)
object CompoundBow extends Bow(dropLevel = 41)
object SniperBow extends Bow(dropLevel = 44)
object IvoryBow extends Bow(dropLevel = 47)
object HighbornBow extends Bow(dropLevel = 50)
object DecimationBow extends Bow(dropLevel = 53)
object ThicketBow extends Bow(dropLevel = 56)
object SteelwoodBow extends Bow(dropLevel = 57)
object CitadelBow extends Bow(dropLevel = 58)
object RangerBow extends Bow(dropLevel = 60)
object AssassinBow extends Bow(dropLevel = 62)
object SpineBow extends Bow(dropLevel = 64)
object ImperialBow extends Bow(dropLevel = 66)
object HarbingerBow extends Bow(dropLevel = 68)
object MarakethBow extends Bow(dropLevel = 71)
