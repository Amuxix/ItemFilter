package me.amuxix.items.bases.accessories

import me.amuxix.conditions.BaseType
import me.amuxix.items.bases.Accessory

sealed abstract class Ring(dropLevel: Int) extends Accessory(dropLevel, "Ring")

case object CoralRing extends Ring(dropLevel = 1)
case object IronRing extends Ring(dropLevel = 1)
case object PauaRing extends Ring(dropLevel = 1)
case object UnsetRing extends Ring(dropLevel = 5)
case object SapphireRing extends Ring(dropLevel = 8)
case object TopazRing extends Ring(dropLevel = 12)
case object RubyRing extends Ring(dropLevel = 16)
case object DiamondRing extends Ring(dropLevel = 20)
case object GoldRing extends Ring(dropLevel = 20)
case object MoonstoneRing extends Ring(dropLevel = 20)
case object TwoStoneRing extends Ring(dropLevel = 20) {
  override def baseType: BaseType = BaseType("Two-Stone Ring")
}
case object AmethystRing extends Ring(dropLevel = 30)
case object PrismaticRing extends Ring(dropLevel = 30)
case object OpalRing extends Ring(dropLevel = 80)
case object SteelRing extends Ring(dropLevel = 80)
