package me.amuxix.items.accessories

import me.amuxix.conditions.BaseType
import me.amuxix.items.Accessory

sealed abstract class Ring(dropLevel: Int) extends Accessory(dropLevel, "Ring")

object CoralRing extends Ring(dropLevel = 1)
object IronRing extends Ring(dropLevel = 1)
object PauaRing extends Ring(dropLevel = 1)
object UnsetRing extends Ring(dropLevel = 5)
object SapphireRing extends Ring(dropLevel = 8)
object TopazRing extends Ring(dropLevel = 12)
object RubyRing extends Ring(dropLevel = 16)
object DiamondRing extends Ring(dropLevel = 20)
object GoldRing extends Ring(dropLevel = 20)
object MoonstoneRing extends Ring(dropLevel = 20)
object TwoStoneRing extends Ring(dropLevel = 20) {
  override def baseType: BaseType = BaseType("Two-Stone Ring")
}
object AmethystRing extends Ring(dropLevel = 30)
object PrismaticRing extends Ring(dropLevel = 30)
object OpalRing extends Ring(dropLevel = 80)
object SteelRing extends Ring(dropLevel = 80)