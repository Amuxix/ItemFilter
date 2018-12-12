package me.amuxix.items.bases

import me.amuxix.conditions.Condition
import me.amuxix.items.Item
import me.amuxix.items.bases.traits.HasRarity

sealed abstract class Flask(dropLevel: Int, itemClass: String) extends Base(2, 1, dropLevel, itemClass + " Flasks") with HasRarity {
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(rarity = None)
}

sealed abstract class LifeFlask(dropLevel: Int) extends Flask(dropLevel, "Life") {
  override lazy val condition: Condition = Condition(base = name, itemLevel = (0, dropLevel + 10))
}

object LifeFlask {
  val flasks: Seq[Item] = Seq(
  SmallLifeFlask,
  MediumLifeFlask,
  LargeLifeFlask,
  GreaterLifeFlask,
  GrandLifeFlask,
  GiantLifeFlask,
  ColossalLifeFlask,
  SacredLifeFlask,
  HallowedLifeFlask,
  SanctifiedLifeFlask,
  DivineLifeFlask,
  EternalLifeFlask,
  )
}

object SmallLifeFlask extends LifeFlask(dropLevel = 1)
object MediumLifeFlask extends LifeFlask(dropLevel = 3)
object LargeLifeFlask extends LifeFlask(dropLevel = 6)
object GreaterLifeFlask extends LifeFlask(dropLevel = 12)
object GrandLifeFlask extends LifeFlask(dropLevel = 18)
object GiantLifeFlask extends LifeFlask(dropLevel = 24)
object ColossalLifeFlask extends LifeFlask(dropLevel = 30)
object SacredLifeFlask extends LifeFlask(dropLevel = 36)
object HallowedLifeFlask extends LifeFlask(dropLevel = 42)
object SanctifiedLifeFlask extends LifeFlask(dropLevel = 50)
object DivineLifeFlask extends LifeFlask(dropLevel = 60)
object EternalLifeFlask extends LifeFlask(dropLevel = 65)

sealed abstract class ManaFlask(dropLevel: Int) extends Flask(dropLevel, "Mana")

object SmallManaFlask extends ManaFlask(dropLevel = 1)
object MediumManaFlask extends ManaFlask(dropLevel = 3)
object LargeManaFlask extends ManaFlask(dropLevel = 6)
object GreaterManaFlask extends ManaFlask(dropLevel = 12)
object GrandManaFlask extends ManaFlask(dropLevel = 18)
object GiantManaFlask extends ManaFlask(dropLevel = 24)
object ColossalManaFlask extends ManaFlask(dropLevel = 30)
object SacredManaFlask extends ManaFlask(dropLevel = 36)
object HallowedManaFlask extends ManaFlask(dropLevel = 42)
object SanctifiedManaFlask extends ManaFlask(dropLevel = 50)
object DivineManaFlask extends ManaFlask(dropLevel = 60)
object EternalManaFlask extends ManaFlask(dropLevel = 65)

sealed abstract class HybridFlask(dropLevel: Int) extends Flask(dropLevel, "Hybrid")

object SmallHybridFlask extends HybridFlask(dropLevel = 10)
object MediumHybridFlask extends HybridFlask(dropLevel = 20)
object LargeHybridFlask extends HybridFlask(dropLevel = 30)
object ColossalHybridFlask extends HybridFlask(dropLevel = 40)
object SacredHybridFlask extends HybridFlask(dropLevel = 50)
object HallowedHybridFlask extends HybridFlask(dropLevel = 60)

sealed abstract class UtilityFlask(dropLevel: Int) extends Flask(dropLevel, "Utility")

object QuicksilverFlask extends UtilityFlask(dropLevel = 4)
object BismuthFlask extends UtilityFlask(dropLevel = 8)
object StibniteFlask extends UtilityFlask(dropLevel = 14)
object AmethystFlask extends UtilityFlask(dropLevel = 18)
object RubyFlask extends UtilityFlask(dropLevel = 18)
object SapphireFlask extends UtilityFlask(dropLevel = 18)
object TopazFlask extends UtilityFlask(dropLevel = 18)
object SilverFlask extends UtilityFlask(dropLevel = 22)
object AquamarineFlask extends UtilityFlask(dropLevel = 27)
object GraniteFlask extends UtilityFlask(dropLevel = 27)
object JadeFlask extends UtilityFlask(dropLevel = 27)
object QuartzFlask extends UtilityFlask(dropLevel = 27)
object SulphurFlask extends UtilityFlask(dropLevel = 35)
object BasaltFlask extends UtilityFlask(dropLevel = 40)
object DiamondFlask extends UtilityFlask(dropLevel = 27)
