package me.amuxix.items.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Wand(dropLevel: Int) extends Item(dropLevel, "Wand")

object DriftwoodWand extends Wand(1)
object GoatsHorn extends Wand(6) {
  override val baseType: BaseType = BaseType("Goat's Horn")
}
object CarvedWand extends Wand(12)
object QuartzWand extends Wand(18)
object SpiraledWand extends Wand(24)
object SageWand extends Wand(30)
object PaganWand extends Wand(34)
object FaunsHorn extends Wand(35) {
  override val baseType: BaseType = BaseType("Faun's Horn")
}
object EngravedWand extends Wand(40)
object CrystalWand extends Wand(45)
object SerpentWand extends Wand(49)
object OmenWand extends Wand(53)
object HeathenWand extends Wand(55)
object DemonsHorn extends Wand(56) {
  override val baseType: BaseType = BaseType("Demon's Horn")
}
object ImbuedWand extends Wand(59)
object OpalWand extends Wand(62)
object TornadoWand extends Wand(65)
object ProphecyWand extends Wand(68)
object ProfaneWand extends Wand(70)
