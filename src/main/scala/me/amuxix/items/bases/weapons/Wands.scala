package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Wand(dropLevel: Int) extends Weapon(3, 1, dropLevel, "Wand")

object Wand extends FilterClass[Wand] {
  override val all: Seq[Wand] = Seq(DriftwoodWand, GoatsHorn, CarvedWand, QuartzWand, SpiraledWand, SageWand, PaganWand, FaunsHorn, EngravedWand, CrystalWand, SerpentWand, OmenWand, HeathenWand, DemonsHorn, ImbuedWand, OpalWand, TornadoWand, ProphecyWand, ProfaneWand)
}

case object DriftwoodWand extends Wand(dropLevel = 1)
case object GoatsHorn extends Wand(dropLevel = 6) {
  override def baseType: BaseType = BaseType("Goat's Horn")
}
case object CarvedWand extends Wand(dropLevel = 12)
case object QuartzWand extends Wand(dropLevel = 18)
case object SpiraledWand extends Wand(dropLevel = 24)
case object SageWand extends Wand(dropLevel = 30)
case object PaganWand extends Wand(dropLevel = 34)
case object FaunsHorn extends Wand(dropLevel = 35) {
  override def baseType: BaseType = BaseType("Faun's Horn")
}
case object EngravedWand extends Wand(dropLevel = 40)
case object CrystalWand extends Wand(dropLevel = 45)
case object SerpentWand extends Wand(dropLevel = 49)
case object OmenWand extends Wand(dropLevel = 53)
case object HeathenWand extends Wand(dropLevel = 55)
case object DemonsHorn extends Wand(dropLevel = 56) {
  override def baseType: BaseType = BaseType("Demon's Horn")
}
case object ImbuedWand extends Wand(dropLevel = 59)
case object OpalWand extends Wand(dropLevel = 62)
case object TornadoWand extends Wand(dropLevel = 65)
case object ProphecyWand extends Wand(dropLevel = 68)
case object ProfaneWand extends Wand(dropLevel = 70)
