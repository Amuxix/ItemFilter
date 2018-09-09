package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.ItemSize
import me.amuxix.items.bases.Weapon

sealed abstract class Sceptre(dropLevel: Int) extends Weapon(ItemSize(3, 2), dropLevel, "Sceptre")

object DriftwoodSceptre extends Sceptre(dropLevel = 1)
object DarkwoodSceptre extends Sceptre(dropLevel = 5)
object BronzeSceptre extends Sceptre(dropLevel = 10)
object QuartzSceptre extends Sceptre(dropLevel = 15)
object IronSceptre extends Sceptre(dropLevel = 20)
object OchreSceptre extends Sceptre(dropLevel = 24)
object RitualSceptre extends Sceptre(dropLevel = 28)
object ShadowSceptre extends Sceptre(dropLevel = 32)
object GrinningFetish extends Sceptre(dropLevel = 35)
object HornedSceptre extends Sceptre(dropLevel = 36)
object Sekhem extends Sceptre(dropLevel = 38)
object CrystalSceptre extends Sceptre(dropLevel = 41)
object LeadSceptre extends Sceptre(dropLevel = 44)
object BloodSceptre extends Sceptre(dropLevel = 47)
object RoyalSceptre extends Sceptre(dropLevel = 50)
object AbyssalSceptre extends Sceptre(dropLevel = 53)
object StagSceptre extends Sceptre(dropLevel = 55)
object KaruiSceptre extends Sceptre(dropLevel = 56)
object TyrantsSekhem extends Sceptre(dropLevel = 58) {
  override def baseType: BaseType = BaseType("Tyrant's Sekhem")
}
object OpalSceptre extends Sceptre(dropLevel = 60)
object PlatinumSceptre extends Sceptre(dropLevel = 62)
object VaalSceptre extends Sceptre(dropLevel = 64)
object CarnalSceptre extends Sceptre(dropLevel = 66)
object VoidSceptre extends Sceptre(dropLevel = 68)
object SambarSceptre extends Sceptre(dropLevel = 70)
