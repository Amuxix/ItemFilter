package me.amuxix.items.bases.weapons

import me.amuxix.conditions.BaseType
import me.amuxix.items.ItemSize
import me.amuxix.items.bases.Weapon

sealed abstract class Claw(dropLevel: Int) extends Weapon(ItemSize(2, 2), dropLevel, "Claw")

object NailedFist extends Claw(dropLevel = 3)
object SharktoothClaw extends Claw(dropLevel = 7)
object Awl extends Claw(dropLevel = 12)
object CatsPaw extends Claw(dropLevel = 17) {
  override def baseType: BaseType = BaseType("Cat's Paw")
}
object Blinder extends Claw(dropLevel = 22)
object TimewornClaw extends Claw(dropLevel = 26)
object SparklingClaw extends Claw(dropLevel = 30)
object FrightClaw extends Claw(dropLevel = 34)
object DoubleClaw extends Claw(dropLevel = 36)
object ThresherClaw extends Claw(dropLevel = 37)
object Gouger extends Claw(dropLevel = 40)
object TigersPaw extends Claw(dropLevel = 43) {
  override def baseType: BaseType = BaseType("Tiger's Paw")
}
object GutRipper extends Claw(dropLevel = 46)
object PrehistoricClaw extends Claw(dropLevel = 49)
object NobleClaw extends Claw(dropLevel = 52)
object EagleClaw extends Claw(dropLevel = 55)
object TwinClaw extends Claw(dropLevel = 57)
object GreatWhiteClaw extends Claw(dropLevel = 58)
object ThroatStabber extends Claw(dropLevel = 60)
object HellionsPaw extends Claw(dropLevel = 62) {
  override def baseType: BaseType = BaseType("Hellion's Paw")
}
object EyeGouger extends Claw(dropLevel = 64)
object VaalClaw extends Claw(dropLevel = 66)
object ImperialClaw extends Claw(dropLevel = 68)
object TerrorClaw extends Claw(dropLevel = 70)
object GeminiClaw extends Claw(dropLevel = 72)
