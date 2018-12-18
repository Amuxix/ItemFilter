package me.amuxix.items.bases.armour

import me.amuxix.conditions.{BaseType, Condition}
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Armour

sealed abstract class Quiver(dropLevel: Int) extends Armour(3, 2, dropLevel, "Quiver")

object Quiver extends FilterClass[Quiver] {
  override val all: Seq[Quiver] = Seq(TwoPointArrowQuiver, SerratedArrowQuiver, SharktoothArrowQuiver, BluntArrowQuiver, FireArrowQuiver, BroadheadArrowQuiver, PenetratingArrowQuiver, SpikePointArrowQuiver)
}

case object TwoPointArrowQuiver extends Quiver(dropLevel = 4) {
  override def baseType: BaseType = BaseType("Two-Point Arrow Quiver")
}
case object SerratedArrowQuiver extends Quiver(dropLevel = 5)
case object SharktoothArrowQuiver extends Quiver(dropLevel = 10)
case object BluntArrowQuiver extends Quiver(dropLevel = 16)
case object FireArrowQuiver extends Quiver(dropLevel = 22)
case object BroadheadArrowQuiver extends Quiver(dropLevel = 28) {
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(itemLevel = None)
}
case object PenetratingArrowQuiver extends Quiver(dropLevel = 36)
case object SpikePointArrowQuiver extends Quiver(dropLevel = 45) {
  override def baseType: BaseType = BaseType("Spike-Point Arrow Quiver")
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(itemLevel = None)
}
