package me.amuxix.items.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Claw(dropLevel: Int) extends Item(dropLevel, "Claw")

object NailedFist extends Claw(3)
object SharktoothClaw extends Claw(7)
object Awl extends Claw(12)
object CatsPaw extends Claw(17) {
  override val baseType: BaseType = BaseType("Cat's Paw")
}
object Blinder extends Claw(22)
object TimewornClaw extends Claw(26)
object SparklingClaw extends Claw(30)
object FrightClaw extends Claw(34)
object DoubleClaw extends Claw(36)
object ThresherClaw extends Claw(37)
object Gouger extends Claw(40)
object TigersPaw extends Claw(43) {
  override val baseType: BaseType = BaseType("Tiger's Paw")
}
object GutRipper extends Claw(46)
object PrehistoricClaw extends Claw(49)
object NobleClaw extends Claw(52)
object EagleClaw extends Claw(55)
object TwinClaw extends Claw(57)
object GreatWhiteClaw extends Claw(58)
object ThroatStabber extends Claw(60)
object HellionsPaw extends Claw(62) {
  override val baseType: BaseType = BaseType("Hellion's Paw")
}
object EyeGouger extends Claw(64)
object VaalClaw extends Claw(66)
object ImperialClaw extends Claw(68)
object TerrorClaw extends Claw(70)
object GeminiClaw extends Claw(72)