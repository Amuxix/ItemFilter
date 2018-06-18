package me.amuxix.items.weapons

import me.amuxix.items.Weapon

sealed abstract class Staff(dropLevel: Int) extends Weapon(dropLevel, "Staff")

object GnarledBranch extends Staff(dropLevel = 4)
object PrimitiveStaff extends Staff(dropLevel = 9)
object LongStaff extends Staff(dropLevel = 13)
object IronStaff extends Staff(dropLevel = 18)
object CoiledStaff extends Staff(dropLevel = 23)
object RoyalStaff extends Staff(dropLevel = 28)
object VileStaff extends Staff(dropLevel = 33)
object CrescentStaff extends Staff(dropLevel = 36)
object WoodfulStaff extends Staff(dropLevel = 37)
object Quarterstaff extends Staff(dropLevel = 41)
object MilitaryStaff extends Staff(dropLevel = 45)
object SerpentineStaff extends Staff(dropLevel = 49)
object HighbornStaff extends Staff(dropLevel = 52)
object FoulStaff extends Staff(dropLevel = 55)
object MoonStaff extends Staff(dropLevel = 57)
object PrimordialStaff extends Staff(dropLevel = 58)
object Lathi extends Staff(dropLevel = 60)
object EzomyteStaff extends Staff(dropLevel = 62)
object MaelströmStaff extends Staff(dropLevel = 64)
object ImperialStaff extends Staff(dropLevel = 66)
object JudgementStaff extends Staff(dropLevel = 68)
object EclipseStaff extends Staff(dropLevel = 70)
