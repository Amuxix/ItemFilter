package me.amuxix.items.bases.weapons
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Mace(height: Int, width: Int, dropLevel: Int, `class`: String) extends Weapon(height, width, dropLevel, `class` + " Mace")

sealed abstract class OneHandedMace(dropLevel: Int) extends Mace(3, 2, dropLevel, "One Handed")

object OneHandedMace extends FilterClass[OneHandedMace] {
  override val all: Seq[OneHandedMace] = Seq(DriftwoodClub, TribalClub, SpikedClub, StoneHammer, WarHammer, BladedMace, CeremonialMace, DreamMace, WyrmMace, PetrifiedClub, BarbedClub, RockBreaker, BattleHammer, FlangedMace, OrnateMace, PhantomMace, DragonMace, AncestralClub, Tenderizer, Gavel, LegionHammer, Pernarch, AuricMace, NightmareMace, BehemothMace)
}

case object DriftwoodClub extends OneHandedMace(dropLevel = 1)
case object TribalClub extends OneHandedMace(dropLevel = 5)
case object SpikedClub extends OneHandedMace(dropLevel = 10)
case object StoneHammer extends OneHandedMace(dropLevel = 15)
case object WarHammer extends OneHandedMace(dropLevel = 20)
case object BladedMace extends OneHandedMace(dropLevel = 24)
case object CeremonialMace extends OneHandedMace(dropLevel = 28)
case object DreamMace extends OneHandedMace(dropLevel = 32)
case object WyrmMace extends OneHandedMace(dropLevel = 34)
case object PetrifiedClub extends OneHandedMace(dropLevel = 35)
case object BarbedClub extends OneHandedMace(dropLevel = 38)
case object RockBreaker extends OneHandedMace(dropLevel = 41)
case object BattleHammer extends OneHandedMace(dropLevel = 44)
case object FlangedMace extends OneHandedMace(dropLevel = 47)
case object OrnateMace extends OneHandedMace(dropLevel = 50)
case object PhantomMace extends OneHandedMace(dropLevel = 53)
case object DragonMace extends OneHandedMace(dropLevel = 55)
case object AncestralClub extends OneHandedMace(dropLevel = 56)
case object Tenderizer extends OneHandedMace(dropLevel = 58)
case object Gavel extends OneHandedMace(dropLevel = 60)
case object LegionHammer extends OneHandedMace(dropLevel = 62)
case object Pernarch extends OneHandedMace(dropLevel = 64)
case object AuricMace extends OneHandedMace(dropLevel = 66)
case object NightmareMace extends OneHandedMace(dropLevel = 68)
case object BehemothMace extends OneHandedMace(dropLevel = 70)

sealed abstract class TwoHandedMace(dropLevel: Int) extends Mace(4, 2, dropLevel, "Two Handed")

object TwoHandedMace extends FilterClass[TwoHandedMace] {
  override val all: Seq[TwoHandedMace] = Seq(DriftwoodMaul, TribalMaul, Mallet, Sledgehammer, JaggedMaul, BrassMaul, FrightMaul, MorningStar, TotemicMaul, GreatMallet, Steelhead, SpinyMaul, PlatedMaul, DreadMaul, SolarMaul, KaruiMaul, ColossusMallet, Piledriver, Meatgrinder, ImperialMaul, TerrorMaul, CoronalMaul)
}

case object DriftwoodMaul extends TwoHandedMace(dropLevel = 3)
case object TribalMaul extends TwoHandedMace(dropLevel = 8)
case object Mallet extends TwoHandedMace(dropLevel = 12)
case object Sledgehammer extends TwoHandedMace(dropLevel = 17)
case object JaggedMaul extends TwoHandedMace(dropLevel = 22)
case object BrassMaul extends TwoHandedMace(dropLevel = 27)
case object FrightMaul extends TwoHandedMace(dropLevel = 32)
case object MorningStar extends TwoHandedMace(dropLevel = 34)
case object TotemicMaul extends TwoHandedMace(dropLevel = 36)
case object GreatMallet extends TwoHandedMace(dropLevel = 40)
case object Steelhead extends TwoHandedMace(dropLevel = 44)
case object SpinyMaul extends TwoHandedMace(dropLevel = 48)
case object PlatedMaul extends TwoHandedMace(dropLevel = 51)
case object DreadMaul extends TwoHandedMace(dropLevel = 54)
case object SolarMaul extends TwoHandedMace(dropLevel = 56)
case object KaruiMaul extends TwoHandedMace(dropLevel = 57)
case object ColossusMallet extends TwoHandedMace(dropLevel = 59)
case object Piledriver extends TwoHandedMace(dropLevel = 61)
case object Meatgrinder extends TwoHandedMace(dropLevel = 63)
case object ImperialMaul extends TwoHandedMace(dropLevel = 65)
case object TerrorMaul extends TwoHandedMace(dropLevel = 67)
case object CoronalMaul extends TwoHandedMace(dropLevel = 69)
