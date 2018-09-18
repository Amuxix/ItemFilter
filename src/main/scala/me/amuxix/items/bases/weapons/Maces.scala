package me.amuxix.items.bases.weapons
import me.amuxix.items.bases.Weapon

sealed abstract class Mace(height: Int, width: Int, dropLevel: Int, `class`: String) extends Weapon(height, width, dropLevel, `class` + " Mace")

sealed abstract class OneHandedMace(dropLevel: Int) extends Mace(3, 2, dropLevel, "One Handed")

object DriftwoodClub extends OneHandedMace(dropLevel = 1)
object TribalClub extends OneHandedMace(dropLevel = 5)
object SpikedClub extends OneHandedMace(dropLevel = 10)
object StoneHammer extends OneHandedMace(dropLevel = 15)
object WarHammer extends OneHandedMace(dropLevel = 20)
object BladedMace extends OneHandedMace(dropLevel = 24)
object CeremonialMace extends OneHandedMace(dropLevel = 28)
object DreamMace extends OneHandedMace(dropLevel = 32)
object WyrmMace extends OneHandedMace(dropLevel = 34)
object PetrifiedClub extends OneHandedMace(dropLevel = 35)
object BarbedClub extends OneHandedMace(dropLevel = 38)
object RockBreaker extends OneHandedMace(dropLevel = 41)
object BattleHammer extends OneHandedMace(dropLevel = 44)
object FlangedMace extends OneHandedMace(dropLevel = 47)
object OrnateMace extends OneHandedMace(dropLevel = 50)
object PhantomMace extends OneHandedMace(dropLevel = 53)
object DragonMace extends OneHandedMace(dropLevel = 55)
object AncestralClub extends OneHandedMace(dropLevel = 56)
object Tenderizer extends OneHandedMace(dropLevel = 58)
object Gavel extends OneHandedMace(dropLevel = 60)
object LegionHammer extends OneHandedMace(dropLevel = 62)
object Pernarch extends OneHandedMace(dropLevel = 64)
object AuricMace extends OneHandedMace(dropLevel = 66)
object NightmareMace extends OneHandedMace(dropLevel = 68)
object BehemothMace extends OneHandedMace(dropLevel = 70)

sealed abstract class TwoHandedMace(dropLevel: Int) extends Mace(4, 2, dropLevel, "Two Handed")

object DriftwoodMaul extends TwoHandedMace(dropLevel = 3)
object TribalMaul extends TwoHandedMace(dropLevel = 8)
object Mallet extends TwoHandedMace(dropLevel = 12)
object Sledgehammer extends TwoHandedMace(dropLevel = 17)
object JaggedMaul extends TwoHandedMace(dropLevel = 22)
object BrassMaul extends TwoHandedMace(dropLevel = 27)
object FrightMaul extends TwoHandedMace(dropLevel = 32)
object MorningStar extends TwoHandedMace(dropLevel = 34)
object TotemicMaul extends TwoHandedMace(dropLevel = 36)
object GreatMallet extends TwoHandedMace(dropLevel = 40)
object Steelhead extends TwoHandedMace(dropLevel = 44)
object SpinyMaul extends TwoHandedMace(dropLevel = 48)
object PlatedMaul extends TwoHandedMace(dropLevel = 51)
object DreadMaul extends TwoHandedMace(dropLevel = 54)
object SolarMaul extends TwoHandedMace(dropLevel = 56)
object KaruiMaul extends TwoHandedMace(dropLevel = 57)
object ColossusMallet extends TwoHandedMace(dropLevel = 59)
object Piledriver extends TwoHandedMace(dropLevel = 61)
object Meatgrinder extends TwoHandedMace(dropLevel = 63)
object ImperialMaul extends TwoHandedMace(dropLevel = 65)
object TerrorMaul extends TwoHandedMace(dropLevel = 67)
object CoronalMaul extends TwoHandedMace(dropLevel = 69)
