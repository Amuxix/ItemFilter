package me.amuxix.items.bases

import me.amuxix.conditions.Condition
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.traits.HasRarity

sealed abstract class Flask(dropLevel: Int, itemClass: String) extends Base(2, 1, dropLevel, itemClass + " Flasks") with HasRarity {
  override def conditionsOfBestRaresForZoneLevel: Condition = super.conditionsOfBestRaresForZoneLevel.copy(rarity = None)
}

sealed abstract class LifeFlask(dropLevel: Int) extends Flask(dropLevel, "Life") {
  override lazy val condition: Condition = Condition(base = name, itemLevel = (1, dropLevel + 10))
}

object LifeFlask extends FilterClass[LifeFlask] {
  val all: Seq[LifeFlask] = Seq(
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

case object SmallLifeFlask extends LifeFlask(dropLevel = 1)
case object MediumLifeFlask extends LifeFlask(dropLevel = 3)
case object LargeLifeFlask extends LifeFlask(dropLevel = 6)
case object GreaterLifeFlask extends LifeFlask(dropLevel = 12)
case object GrandLifeFlask extends LifeFlask(dropLevel = 18)
case object GiantLifeFlask extends LifeFlask(dropLevel = 24)
case object ColossalLifeFlask extends LifeFlask(dropLevel = 30)
case object SacredLifeFlask extends LifeFlask(dropLevel = 36)
case object HallowedLifeFlask extends LifeFlask(dropLevel = 42)
case object SanctifiedLifeFlask extends LifeFlask(dropLevel = 50)
case object DivineLifeFlask extends LifeFlask(dropLevel = 60)
case object EternalLifeFlask extends LifeFlask(dropLevel = 65)

sealed abstract class ManaFlask(dropLevel: Int) extends Flask(dropLevel, "Mana")

object ManaFlask extends FilterClass[ManaFlask] {
  val all: Seq[ManaFlask] = Seq(SmallManaFlask, MediumManaFlask, LargeManaFlask, GreaterManaFlask, GrandManaFlask, GiantManaFlask, ColossalManaFlask, SacredManaFlask, HallowedManaFlask, SanctifiedManaFlask, DivineManaFlask, EternalManaFlask)
}

case object SmallManaFlask extends ManaFlask(dropLevel = 1)
case object MediumManaFlask extends ManaFlask(dropLevel = 3)
case object LargeManaFlask extends ManaFlask(dropLevel = 6)
case object GreaterManaFlask extends ManaFlask(dropLevel = 12)
case object GrandManaFlask extends ManaFlask(dropLevel = 18)
case object GiantManaFlask extends ManaFlask(dropLevel = 24)
case object ColossalManaFlask extends ManaFlask(dropLevel = 30)
case object SacredManaFlask extends ManaFlask(dropLevel = 36)
case object HallowedManaFlask extends ManaFlask(dropLevel = 42)
case object SanctifiedManaFlask extends ManaFlask(dropLevel = 50)
case object DivineManaFlask extends ManaFlask(dropLevel = 60)
case object EternalManaFlask extends ManaFlask(dropLevel = 65)

sealed abstract class HybridFlask(dropLevel: Int) extends Flask(dropLevel, "Hybrid")

object HybridFlask extends FilterClass[HybridFlask] {
  val all: Seq[HybridFlask] = Seq(SmallHybridFlask, MediumHybridFlask, LargeHybridFlask, ColossalHybridFlask, SacredHybridFlask, HallowedHybridFlask)
}

case object SmallHybridFlask extends HybridFlask(dropLevel = 10)
case object MediumHybridFlask extends HybridFlask(dropLevel = 20)
case object LargeHybridFlask extends HybridFlask(dropLevel = 30)
case object ColossalHybridFlask extends HybridFlask(dropLevel = 40)
case object SacredHybridFlask extends HybridFlask(dropLevel = 50)
case object HallowedHybridFlask extends HybridFlask(dropLevel = 60)

sealed abstract class UtilityFlask(dropLevel: Int) extends Flask(dropLevel, "Utility")

object UtilityFlask extends FilterClass[UtilityFlask] {
  val all: Seq[UtilityFlask] = Seq(QuicksilverFlask, BismuthFlask, StibniteFlask, AmethystFlask, RubyFlask, SapphireFlask, TopazFlask, SilverFlask, AquamarineFlask, GraniteFlask, JadeFlask, QuartzFlask, SulphurFlask, BasaltFlask, DiamondFlask)
}

case object QuicksilverFlask extends UtilityFlask(dropLevel = 4)
case object BismuthFlask extends UtilityFlask(dropLevel = 8)
case object StibniteFlask extends UtilityFlask(dropLevel = 14)
case object AmethystFlask extends UtilityFlask(dropLevel = 18)
case object RubyFlask extends UtilityFlask(dropLevel = 18)
case object SapphireFlask extends UtilityFlask(dropLevel = 18)
case object TopazFlask extends UtilityFlask(dropLevel = 18)
case object SilverFlask extends UtilityFlask(dropLevel = 22)
case object AquamarineFlask extends UtilityFlask(dropLevel = 27)
case object GraniteFlask extends UtilityFlask(dropLevel = 27)
case object JadeFlask extends UtilityFlask(dropLevel = 27)
case object QuartzFlask extends UtilityFlask(dropLevel = 27)
case object SulphurFlask extends UtilityFlask(dropLevel = 35)
case object BasaltFlask extends UtilityFlask(dropLevel = 40)
case object DiamondFlask extends UtilityFlask(dropLevel = 27)
