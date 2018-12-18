package me.amuxix.items.bases.weapons
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Staff(dropLevel: Int) extends Weapon(4, 2, dropLevel, "Staff")

object Staff extends FilterClass[Staff] {
  override val all: Seq[Staff] = Seq(GnarledBranch, PrimitiveStaff, LongStaff, IronStaff, CoiledStaff, RoyalStaff, VileStaff, CrescentStaff, WoodfulStaff, Quarterstaff, MilitaryStaff, SerpentineStaff, HighbornStaff, FoulStaff, MoonStaff, PrimordialStaff, Lathi, EzomyteStaff, MaelströmStaff, ImperialStaff, JudgementStaff, EclipseStaff)
}

case object GnarledBranch extends Staff(dropLevel = 4)
case object PrimitiveStaff extends Staff(dropLevel = 9)
case object LongStaff extends Staff(dropLevel = 13)
case object IronStaff extends Staff(dropLevel = 18)
case object CoiledStaff extends Staff(dropLevel = 23)
case object RoyalStaff extends Staff(dropLevel = 28)
case object VileStaff extends Staff(dropLevel = 33)
case object CrescentStaff extends Staff(dropLevel = 36)
case object WoodfulStaff extends Staff(dropLevel = 37)
case object Quarterstaff extends Staff(dropLevel = 41)
case object MilitaryStaff extends Staff(dropLevel = 45)
case object SerpentineStaff extends Staff(dropLevel = 49)
case object HighbornStaff extends Staff(dropLevel = 52)
case object FoulStaff extends Staff(dropLevel = 55)
case object MoonStaff extends Staff(dropLevel = 57)
case object PrimordialStaff extends Staff(dropLevel = 58)
case object Lathi extends Staff(dropLevel = 60)
case object EzomyteStaff extends Staff(dropLevel = 62)
object MaelströmStaff extends Staff(dropLevel = 64)
case object ImperialStaff extends Staff(dropLevel = 66)
case object JudgementStaff extends Staff(dropLevel = 68)
case object EclipseStaff extends Staff(dropLevel = 70)
