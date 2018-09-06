package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Size
import me.amuxix.items.bases.Weapon

sealed abstract class Wand(dropLevel: Int) extends Weapon(Size(3, 1), dropLevel, "Wand")

object DriftwoodWand extends Wand(dropLevel = 1)
object GoatsHorn extends Wand(dropLevel = 6) {
  override def baseType: BaseType = BaseType("Goat's Horn")
}
object CarvedWand extends Wand(dropLevel = 12)
object QuartzWand extends Wand(dropLevel = 18)
object SpiraledWand extends Wand(dropLevel = 24)
object SageWand extends Wand(dropLevel = 30)
object PaganWand extends Wand(dropLevel = 34)
object FaunsHorn extends Wand(dropLevel = 35) {
  override def baseType: BaseType = BaseType("Faun's Horn")
}
object EngravedWand extends Wand(dropLevel = 40)
object CrystalWand extends Wand(dropLevel = 45)
object SerpentWand extends Wand(dropLevel = 49)
object OmenWand extends Wand(dropLevel = 53)
object HeathenWand extends Wand(dropLevel = 55)
object DemonsHorn extends Wand(dropLevel = 56) {
  override def baseType: BaseType = BaseType("Demon's Horn")
}
object ImbuedWand extends Wand(dropLevel = 59)
object OpalWand extends Wand(dropLevel = 62)
object TornadoWand extends Wand(dropLevel = 65)
object ProphecyWand extends Wand(dropLevel = 68)
object ProfaneWand extends Wand(dropLevel = 70)
