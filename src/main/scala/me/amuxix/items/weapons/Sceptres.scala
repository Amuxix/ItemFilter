package me.amuxix.items.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Sceptre(dropLevel: Int) extends Item(dropLevel, "Sceptre")

object DriftwoodSceptre extends Sceptre(1)
object DarkwoodSceptre extends Sceptre(5)
object BronzeSceptre extends Sceptre(10)
object QuartzSceptre extends Sceptre(15)
object IronSceptre extends Sceptre(20)
object OchreSceptre extends Sceptre(24)
object RitualSceptre extends Sceptre(28)
object ShadowSceptre extends Sceptre(32)
object GrinningFetish extends Sceptre(35)
object HornedSceptre extends Sceptre(36)
object Sekhem extends Sceptre(38)
object CrystalSceptre extends Sceptre(41)
object LeadSceptre extends Sceptre(44)
object BloodSceptre extends Sceptre(47)
object RoyalSceptre extends Sceptre(50)
object AbyssalSceptre extends Sceptre(53)
object StagSceptre extends Sceptre(55)
object KaruiSceptre extends Sceptre(56)
object TyrantsSekhem extends Sceptre(58) {
  override val baseType: BaseType = BaseType("Tyrant's Sekhem")
}
object OpalSceptre extends Sceptre(60)
object PlatinumSceptre extends Sceptre(62)
object VaalSceptre extends Sceptre(64)
object CarnalSceptre extends Sceptre(66)
object VoidSceptre extends Sceptre(68)
object SambarSceptre extends Sceptre(70)