package me.amuxix.items.weapons

import me.amuxix.items.Item

sealed abstract class Staff(dropLevel: Int) extends Item(dropLevel, "Staff")

object GnarledBranch extends Staff(4)
object PrimitiveStaff extends Staff(9)
object LongStaff extends Staff(13)
object IronStaff extends Staff(18)
object CoiledStaff extends Staff(23)
object RoyalStaff extends Staff(28)
object VileStaff extends Staff(33)
object CrescentStaff extends Staff(36)
object WoodfulStaff extends Staff(37)
object Quarterstaff extends Staff(41)
object MilitaryStaff extends Staff(45)
object SerpentineStaff extends Staff(49)
object HighbornStaff extends Staff(52)
object FoulStaff extends Staff(55)
object MoonStaff extends Staff(57)
object PrimordialStaff extends Staff(58)
object Lathi extends Staff(60)
object EzomyteStaff extends Staff(62)
object MaelströmStaff extends Staff(64)
object ImperialStaff extends Staff(66)
object JudgementStaff extends Staff(68)
object EclipseStaff extends Staff(70)