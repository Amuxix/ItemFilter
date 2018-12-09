package me.amuxix.items.bases.armour

import me.amuxix.conditions.{BaseType, Condition}
import me.amuxix.items.bases.Armour

sealed abstract class Quiver(dropLevel: Int) extends Armour(3, 2, dropLevel, "Quiver")

object TwoPointArrowQuiver extends Quiver(dropLevel = 4) {
  override def baseType: BaseType = BaseType("Two-Point Arrow Quiver")
}
object SerratedArrowQuiver extends Quiver(dropLevel = 5)
object SharktoothArrowQuiver extends Quiver(dropLevel = 10)
object BluntArrowQuiver extends Quiver(dropLevel = 16)
object FireArrowQuiver extends Quiver(dropLevel = 22)
object BroadheadArrowQuiver extends Quiver(dropLevel = 28) {
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(itemLevel = None)
}
object PenetratingArrowQuiver extends Quiver(dropLevel = 36)
object SpikePointArrowQuiver extends Quiver(dropLevel = 45) {
  override def baseType: BaseType = BaseType("Spike-Point Arrow Quiver")
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(itemLevel = None)
}
