package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class BodyArmour(dropLevel: Int) extends Item(dropLevel, "Body Armour")

//Armour
object PlateVest extends BodyArmour(1)
object Chestplate extends BodyArmour(6)
object CopperPlate extends BodyArmour(17)
object WarPlate extends BodyArmour(21)
object FullPlate extends BodyArmour(28)
object ArenaPlate extends BodyArmour(32)
object LordlyPlate extends BodyArmour(35)
object BronzePlate extends BodyArmour(37)
object BattlePlate extends BodyArmour(41)
object SunPlate extends BodyArmour(45)
object ColosseumPlate extends BodyArmour(49)
object MajesticPlate extends BodyArmour(53)
object GoldenPlate extends BodyArmour(56)
object CrusaderPlate extends BodyArmour(59)
object AstralPlate extends BodyArmour(62)
object GladiatorPlate extends BodyArmour(65)
object GloriousPlate extends BodyArmour(68)

//Evasion
object ShabbyJerkin extends BodyArmour(2)
object StrappedLeather extends BodyArmour(9)
object BuckskinTunic extends BodyArmour(17)
object WildLeather extends BodyArmour(25)
object FullLeather extends BodyArmour(28)
object SunLeather extends BodyArmour(32)
object ThiefsGarb extends BodyArmour(35) {
  override val baseType: BaseType = BaseType("Thief's Garb")
}
object EelskinTunic extends BodyArmour(37)
object FrontierLeather extends BodyArmour(41)
object GloriousLeather extends BodyArmour(45)
object CoronalLeather extends BodyArmour(49)
object CutthroatsGarb extends BodyArmour(53) {
  override val baseType: BaseType = BaseType("Cutthroat's Garb")
}
object SharkskinTunic extends BodyArmour(56)
object DestinyLeather extends BodyArmour(59)
object ExquisiteLeather extends BodyArmour(62)
object ZodiacLeather extends BodyArmour(65)
object AssassinsGarb extends BodyArmour(68) {
  override val baseType: BaseType = BaseType("Assassin's Garb")
}

//ES
object SimpleRobe extends BodyArmour(3)
object SilkenVest extends BodyArmour(11)
object ScholarsRobe extends BodyArmour(18) {
  override val baseType: BaseType = BaseType("Scholar's Robe")
}
object SilkenGarb extends BodyArmour(25)
object MagesVestment extends BodyArmour(28) {
  override val baseType: BaseType = BaseType("Mage's Vestment")
}
object SilkRobe extends BodyArmour(32)
object CabalistRegalia extends BodyArmour(35)
object SagesRobe extends BodyArmour(37) {
  override val baseType: BaseType = BaseType("Sage's Robe")
}
object SilkenWrap extends BodyArmour(41)
object ConjurersVestment extends BodyArmour(45) {
  override val baseType: BaseType = BaseType("Conjurer's Vestment")
}
object SpidersilkRobe extends BodyArmour(49)
object DestroyerRegalia extends BodyArmour(53)
object SavantsRobe extends BodyArmour(56) {
  override val baseType: BaseType = BaseType("Savant's Robe")
}
object NecromancerSilks extends BodyArmour(59)
object OccultistsVestment extends BodyArmour(62) {
  override val baseType: BaseType = BaseType("Occultist's Vestment")
}
object WidowsilkRobe extends BodyArmour(65)
object VaalRegalia extends BodyArmour(68)

//Armour+Evasion
object ScaleVest extends BodyArmour(4)
object LightBrigandine extends BodyArmour(8)
object ScaleDoublet extends BodyArmour(17)
object InfantryBrigandine extends BodyArmour(21)
object FullScaleArmour extends BodyArmour(28)
object SoldiersBrigandine extends BodyArmour(32) {
  override val baseType: BaseType = BaseType("Soldier's Brigandine")
}
object FieldLamellar extends BodyArmour(35)
object WyrmscaleDoublet extends BodyArmour(38)
object HussarBrigandine extends BodyArmour(42)
object FullWyrmscale extends BodyArmour(46)
object CommandersBrigandine extends BodyArmour(50) {
  override val baseType: BaseType = BaseType("Commander's Brigandine")
}
object BattleLamellar extends BodyArmour(54)
object DragonscaleDoublet extends BodyArmour(57)
object DesertBrigandine extends BodyArmour(60)
object FullDragonscale extends BodyArmour(63)
object GeneralsBrigandine extends BodyArmour(66) {
  override val baseType: BaseType = BaseType("General's Brigandine")
}
object TriumphantLamellar extends BodyArmour(69)

//Armour+ES
object ChainmailVest extends BodyArmour(4)
object ChainmailTunic extends BodyArmour(8)
object RingmailCoat extends BodyArmour(17)
object ChainmailDoublet extends BodyArmour(21)
object FullRingmail extends BodyArmour(28)
object FullChainmail extends BodyArmour(32)
object HolyChainmail extends BodyArmour(35)
object LatticedRingmail extends BodyArmour(39)
object CrusaderChainmail extends BodyArmour(43)
object OrnateRingmail extends BodyArmour(47)
object ChainHauberk extends BodyArmour(51)
object DevoutChainmail extends BodyArmour(55)
object LoricatedRingmail extends BodyArmour(58)
object ConquestChainmail extends BodyArmour(61)
object ElegantRingmail extends BodyArmour(64)
object SaintsHauberk extends BodyArmour(67) {
  override val baseType: BaseType = BaseType("Saint's Hauberk")
}
object SaintlyChainmail extends BodyArmour(70)

//Evasion+ES
object PaddedVest extends BodyArmour(4)
object OiledVest extends BodyArmour(9)
object PaddedJacket extends BodyArmour(18)
object OiledCoat extends BodyArmour(22)
object ScarletRaiment extends BodyArmour(28)
object WaxedGarb extends BodyArmour(32)
object BoneArmour extends BodyArmour(35)
object QuiltedJacket extends BodyArmour(40)
object SleekCoat extends BodyArmour(44)
object CrimsonRaiment extends BodyArmour(48)
object LacqueredGarb extends BodyArmour(52)
object CryptArmour extends BodyArmour(56)
object SentinelJacket extends BodyArmour(59)
object VarnishedCoat extends BodyArmour(62)
object BloodRaiment extends BodyArmour(65)
object SadistGarb extends BodyArmour(68)
object CarnalArmour extends BodyArmour(71)