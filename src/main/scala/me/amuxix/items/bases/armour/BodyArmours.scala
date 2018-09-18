package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.bases.Armour

sealed abstract class BodyArmour(dropLevel: Int) extends Armour(3, 2, dropLevel, "Body Armour")

//Armour
object PlateVest extends BodyArmour(dropLevel = 1)
object Chestplate extends BodyArmour(dropLevel = 6)
object CopperPlate extends BodyArmour(dropLevel = 17)
object WarPlate extends BodyArmour(dropLevel = 21)
object FullPlate extends BodyArmour(dropLevel = 28)
object ArenaPlate extends BodyArmour(dropLevel = 32)
object LordlyPlate extends BodyArmour(dropLevel = 35)
object BronzePlate extends BodyArmour(dropLevel = 37)
object BattlePlate extends BodyArmour(dropLevel = 41)
object SunPlate extends BodyArmour(dropLevel = 45)
object ColosseumPlate extends BodyArmour(dropLevel = 49)
object MajesticPlate extends BodyArmour(dropLevel = 53)
object GoldenPlate extends BodyArmour(dropLevel = 56)
object CrusaderPlate extends BodyArmour(dropLevel = 59)
object AstralPlate extends BodyArmour(dropLevel = 62)
object GladiatorPlate extends BodyArmour(dropLevel = 65)
object GloriousPlate extends BodyArmour(dropLevel = 68)

//Evasion
object ShabbyJerkin extends BodyArmour(dropLevel = 2)
object StrappedLeather extends BodyArmour(dropLevel = 9)
object BuckskinTunic extends BodyArmour(dropLevel = 17)
object WildLeather extends BodyArmour(dropLevel = 25)
object FullLeather extends BodyArmour(dropLevel = 28)
object SunLeather extends BodyArmour(dropLevel = 32)
object ThiefsGarb extends BodyArmour(dropLevel = 35) {
  override def baseType: BaseType = BaseType("Thief's Garb")
}
object EelskinTunic extends BodyArmour(dropLevel = 37)
object FrontierLeather extends BodyArmour(dropLevel = 41)
object GloriousLeather extends BodyArmour(dropLevel = 45)
object CoronalLeather extends BodyArmour(dropLevel = 49)
object CutthroatsGarb extends BodyArmour(dropLevel = 53) {
  override def baseType: BaseType = BaseType("Cutthroat's Garb")
}
object SharkskinTunic extends BodyArmour(dropLevel = 56)
object DestinyLeather extends BodyArmour(dropLevel = 59)
object ExquisiteLeather extends BodyArmour(dropLevel = 62)
object ZodiacLeather extends BodyArmour(dropLevel = 65)
object AssassinsGarb extends BodyArmour(dropLevel = 68) {
  override def baseType: BaseType = BaseType("Assassin's Garb")
}

//ES
object SimpleRobe extends BodyArmour(dropLevel = 3)
object SilkenVest extends BodyArmour(dropLevel = 11)
object ScholarsRobe extends BodyArmour(dropLevel = 18) {
  override def baseType: BaseType = BaseType("Scholar's Robe")
}
object SilkenGarb extends BodyArmour(dropLevel = 25)
object MagesVestment extends BodyArmour(dropLevel = 28) {
  override def baseType: BaseType = BaseType("Mage's Vestment")
}
object SilkRobe extends BodyArmour(dropLevel = 32)
object CabalistRegalia extends BodyArmour(dropLevel = 35)
object SagesRobe extends BodyArmour(dropLevel = 37) {
  override def baseType: BaseType = BaseType("Sage's Robe")
}
object SilkenWrap extends BodyArmour(dropLevel = 41)
object ConjurersVestment extends BodyArmour(dropLevel = 45) {
  override def baseType: BaseType = BaseType("Conjurer's Vestment")
}
object SpidersilkRobe extends BodyArmour(dropLevel = 49)
object DestroyerRegalia extends BodyArmour(dropLevel = 53)
object SavantsRobe extends BodyArmour(dropLevel = 56) {
  override def baseType: BaseType = BaseType("Savant's Robe")
}
object NecromancerSilks extends BodyArmour(dropLevel = 59)
object OccultistsVestment extends BodyArmour(dropLevel = 62) {
  override def baseType: BaseType = BaseType("Occultist's Vestment")
}
object WidowsilkRobe extends BodyArmour(dropLevel = 65)
object VaalRegalia extends BodyArmour(dropLevel = 68)

//Armour+Evasion
object ScaleVest extends BodyArmour(dropLevel = 4)
object LightBrigandine extends BodyArmour(dropLevel = 8)
object ScaleDoublet extends BodyArmour(dropLevel = 17)
object InfantryBrigandine extends BodyArmour(dropLevel = 21)
object FullScaleArmour extends BodyArmour(dropLevel = 28)
object SoldiersBrigandine extends BodyArmour(dropLevel = 32) {
  override def baseType: BaseType = BaseType("Soldier's Brigandine")
}
object FieldLamellar extends BodyArmour(dropLevel = 35)
object WyrmscaleDoublet extends BodyArmour(dropLevel = 38)
object HussarBrigandine extends BodyArmour(dropLevel = 42)
object FullWyrmscale extends BodyArmour(dropLevel = 46)
object CommandersBrigandine extends BodyArmour(dropLevel = 50) {
  override def baseType: BaseType = BaseType("Commander's Brigandine")
}
object BattleLamellar extends BodyArmour(dropLevel = 54)
object DragonscaleDoublet extends BodyArmour(dropLevel = 57)
object DesertBrigandine extends BodyArmour(dropLevel = 60)
object FullDragonscale extends BodyArmour(dropLevel = 63)
object GeneralsBrigandine extends BodyArmour(dropLevel = 66) {
  override def baseType: BaseType = BaseType("General's Brigandine")
}
object TriumphantLamellar extends BodyArmour(dropLevel = 69)

//Armour+ES
object ChainmailVest extends BodyArmour(dropLevel = 4)
object ChainmailTunic extends BodyArmour(dropLevel = 8)
object RingmailCoat extends BodyArmour(dropLevel = 17)
object ChainmailDoublet extends BodyArmour(dropLevel = 21)
object FullRingmail extends BodyArmour(dropLevel = 28)
object FullChainmail extends BodyArmour(dropLevel = 32)
object HolyChainmail extends BodyArmour(dropLevel = 35)
object LatticedRingmail extends BodyArmour(dropLevel = 39)
object CrusaderChainmail extends BodyArmour(dropLevel = 43)
object OrnateRingmail extends BodyArmour(dropLevel = 47)
object ChainHauberk extends BodyArmour(dropLevel = 51)
object DevoutChainmail extends BodyArmour(dropLevel = 55)
object LoricatedRingmail extends BodyArmour(dropLevel = 58)
object ConquestChainmail extends BodyArmour(dropLevel = 61)
object ElegantRingmail extends BodyArmour(dropLevel = 64)
object SaintsHauberk extends BodyArmour(dropLevel = 67) {
  override def baseType: BaseType = BaseType("Saint's Hauberk")
}
object SaintlyChainmail extends BodyArmour(dropLevel = 70)

//Evasion+ES
object PaddedVest extends BodyArmour(dropLevel = 4)
object OiledVest extends BodyArmour(dropLevel = 9)
object PaddedJacket extends BodyArmour(dropLevel = 18)
object OiledCoat extends BodyArmour(dropLevel = 22)
object ScarletRaiment extends BodyArmour(dropLevel = 28)
object WaxedGarb extends BodyArmour(dropLevel = 32)
object BoneArmour extends BodyArmour(dropLevel = 35)
object QuiltedJacket extends BodyArmour(dropLevel = 40)
object SleekCoat extends BodyArmour(dropLevel = 44)
object CrimsonRaiment extends BodyArmour(dropLevel = 48)
object LacqueredGarb extends BodyArmour(dropLevel = 52)
object CryptArmour extends BodyArmour(dropLevel = 56)
object SentinelJacket extends BodyArmour(dropLevel = 59)
object VarnishedCoat extends BodyArmour(dropLevel = 62)
object BloodRaiment extends BodyArmour(dropLevel = 65)
object SadistGarb extends BodyArmour(dropLevel = 68)
object CarnalArmour extends BodyArmour(dropLevel = 71)
