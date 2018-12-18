package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Claw(dropLevel: Int) extends Weapon(2, 2, dropLevel, "Claw") {}

object Claw extends FilterClass[Claw] {
  override val all: Seq[Claw] = Seq(NailedFist, SharktoothClaw, Awl, CatsPaw, Blinder, TimewornClaw, SparklingClaw, FrightClaw, DoubleClaw, ThresherClaw, Gouger, TigersPaw, GutRipper, PrehistoricClaw, NobleClaw, EagleClaw, TwinClaw, GreatWhiteClaw, ThroatStabber, HellionsPaw, EyeGouger, VaalClaw, ImperialClaw, TerrorClaw, GeminiClaw)
}

case object NailedFist extends Claw(dropLevel = 3)
case object SharktoothClaw extends Claw(dropLevel = 7)
case object Awl extends Claw(dropLevel = 12)
case object CatsPaw extends Claw(dropLevel = 17) {
  override def baseType: BaseType = BaseType("Cat's Paw")
}
case object Blinder extends Claw(dropLevel = 22)
case object TimewornClaw extends Claw(dropLevel = 26)
case object SparklingClaw extends Claw(dropLevel = 30)
case object FrightClaw extends Claw(dropLevel = 34)
case object DoubleClaw extends Claw(dropLevel = 36)
case object ThresherClaw extends Claw(dropLevel = 37)
case object Gouger extends Claw(dropLevel = 40)
case object TigersPaw extends Claw(dropLevel = 43) {
  override def baseType: BaseType = BaseType("Tiger's Paw")
}
case object GutRipper extends Claw(dropLevel = 46)
case object PrehistoricClaw extends Claw(dropLevel = 49)
case object NobleClaw extends Claw(dropLevel = 52)
case object EagleClaw extends Claw(dropLevel = 55)
case object TwinClaw extends Claw(dropLevel = 57)
case object GreatWhiteClaw extends Claw(dropLevel = 58)
case object ThroatStabber extends Claw(dropLevel = 60)
case object HellionsPaw extends Claw(dropLevel = 62) {
  override def baseType: BaseType = BaseType("Hellion's Paw")
}
case object EyeGouger extends Claw(dropLevel = 64)
case object VaalClaw extends Claw(dropLevel = 66)
case object ImperialClaw extends Claw(dropLevel = 68)
case object TerrorClaw extends Claw(dropLevel = 70)
case object GeminiClaw extends Claw(dropLevel = 72)
