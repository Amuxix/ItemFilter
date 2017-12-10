package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Armour

sealed abstract class Quiver(dropLevel: Int) extends Armour(dropLevel, "Quiver")

object TwoPointArrowQuiver extends Quiver(dropLevel = 4) {
  override def baseType: BaseType = BaseType("Two-Point Arrow Quiver")
}
object SerratedArrowQuiver extends Quiver(dropLevel = 5)
object SharktoothArrowQuiver extends Quiver(dropLevel = 10)
object BluntArrowQuiver extends Quiver(dropLevel = 16)
object FireArrowQuiver extends Quiver(dropLevel = 22)
object BroadheadArrowQuiver extends Quiver(dropLevel = 28)
object PenetratingArrowQuiver extends Quiver(dropLevel = 36)
object SpikePointArrowQuiver extends Quiver(dropLevel = 45) {
  override def baseType: BaseType = BaseType("Spike-Point Arrow Quiver")
}