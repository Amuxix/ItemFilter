package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Sceptre(dropLevel: Int) extends Weapon(3, 2, dropLevel, "Sceptre")

object Sceptre extends FilterClass[Sceptre] {
  override val all: Seq[Sceptre] = Seq(DriftwoodSceptre, DarkwoodSceptre, BronzeSceptre, QuartzSceptre, IronSceptre, OchreSceptre, RitualSceptre, ShadowSceptre, GrinningFetish, HornedSceptre, Sekhem, CrystalSceptre, LeadSceptre, BloodSceptre, RoyalSceptre, AbyssalSceptre, StagSceptre, KaruiSceptre, TyrantsSekhem, OpalSceptre, PlatinumSceptre, VaalSceptre, CarnalSceptre, VoidSceptre, SambarSceptre)
}

case object DriftwoodSceptre extends Sceptre(dropLevel = 1)
case object DarkwoodSceptre extends Sceptre(dropLevel = 5)
case object BronzeSceptre extends Sceptre(dropLevel = 10)
case object QuartzSceptre extends Sceptre(dropLevel = 15)
case object IronSceptre extends Sceptre(dropLevel = 20)
case object OchreSceptre extends Sceptre(dropLevel = 24)
case object RitualSceptre extends Sceptre(dropLevel = 28)
case object ShadowSceptre extends Sceptre(dropLevel = 32)
case object GrinningFetish extends Sceptre(dropLevel = 35)
case object HornedSceptre extends Sceptre(dropLevel = 36)
case object Sekhem extends Sceptre(dropLevel = 38)
case object CrystalSceptre extends Sceptre(dropLevel = 41)
case object LeadSceptre extends Sceptre(dropLevel = 44)
case object BloodSceptre extends Sceptre(dropLevel = 47)
case object RoyalSceptre extends Sceptre(dropLevel = 50)
case object AbyssalSceptre extends Sceptre(dropLevel = 53)
case object StagSceptre extends Sceptre(dropLevel = 55)
case object KaruiSceptre extends Sceptre(dropLevel = 56)
case object TyrantsSekhem extends Sceptre(dropLevel = 58) {
  override def baseType: BaseType = BaseType("Tyrant's Sekhem")
}
case object OpalSceptre extends Sceptre(dropLevel = 60)
case object PlatinumSceptre extends Sceptre(dropLevel = 62)
case object VaalSceptre extends Sceptre(dropLevel = 64)
case object CarnalSceptre extends Sceptre(dropLevel = 66)
case object VoidSceptre extends Sceptre(dropLevel = 68)
case object SambarSceptre extends Sceptre(dropLevel = 70)
