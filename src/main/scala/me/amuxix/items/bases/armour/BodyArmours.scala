package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Armour

sealed abstract class BodyArmour(dropLevel: Int) extends Armour(3, 2, dropLevel, "Body Armour")

object BodyArmour extends FilterClass[BodyArmour] {
  // format: off
  val armourBodyArmours: Seq[BodyArmour] = Seq(PlateVest, Chestplate, CopperPlate, WarPlate, FullPlate, ArenaPlate, LordlyPlate, BronzePlate, BattlePlate, SunPlate, ColosseumPlate, MajesticPlate, GoldenPlate, CrusaderPlate, AstralPlate, GladiatorPlate, GloriousPlate)
  val evasionBodyArmours: Seq[BodyArmour] = Seq(ShabbyJerkin, StrappedLeather, BuckskinTunic, WildLeather, FullLeather, SunLeather, ThiefsGarb, EelskinTunic, FrontierLeather, GloriousLeather, CoronalLeather, CutthroatsGarb, SharkskinTunic, DestinyLeather, ExquisiteLeather, ZodiacLeather, AssassinsGarb)
  val energyShieldBodyArmours: Seq[BodyArmour] = Seq(SimpleRobe, SilkenVest, ScholarsRobe, SilkenGarb, MagesVestment, SilkRobe, CabalistRegalia, SagesRobe, SilkenWrap, ConjurersVestment, SpidersilkRobe, DestroyerRegalia, SavantsRobe, NecromancerSilks, OccultistsVestment, WidowsilkRobe, VaalRegalia)
  val armourEvasionBodyArmours: Seq[BodyArmour] = Seq(ScaleVest, LightBrigandine, ScaleDoublet, InfantryBrigandine, FullScaleArmour, SoldiersBrigandine, FieldLamellar, WyrmscaleDoublet, HussarBrigandine, FullWyrmscale, CommandersBrigandine, BattleLamellar, DragonscaleDoublet, DesertBrigandine, FullDragonscale, GeneralsBrigandine, TriumphantLamellar)
  val armourEnergyShieldBodyArmours: Seq[BodyArmour] = Seq(ChainmailVest, ChainmailTunic, RingmailCoat, ChainmailDoublet, FullRingmail, FullChainmail, HolyChainmail, LatticedRingmail, CrusaderChainmail, OrnateRingmail, ChainHauberk, DevoutChainmail, LoricatedRingmail, ConquestChainmail, ElegantRingmail, SaintsHauberk, SaintlyChainmail)
  val evasionEnergyShieldBodyArmours: Seq[BodyArmour] = Seq(PaddedVest, OiledVest, PaddedJacket, OiledCoat, ScarletRaiment, WaxedGarb, BoneArmour, QuiltedJacket, SleekCoat, CrimsonRaiment, LacqueredGarb, CryptArmour, SentinelJacket, VarnishedCoat, BloodRaiment, SadistGarb, CarnalArmour)
  val bodyArmours: Seq[Seq[BodyArmour]] = Seq(armourBodyArmours, evasionBodyArmours, energyShieldBodyArmours, armourEvasionBodyArmours, armourEnergyShieldBodyArmours, evasionEnergyShieldBodyArmours)
  // format: on
  override val all: Seq[BodyArmour] = bodyArmours.flatten
}

//Armour
case object PlateVest extends BodyArmour(dropLevel = 1)
case object Chestplate extends BodyArmour(dropLevel = 6)
case object CopperPlate extends BodyArmour(dropLevel = 17)
case object WarPlate extends BodyArmour(dropLevel = 21)
case object FullPlate extends BodyArmour(dropLevel = 28)
case object ArenaPlate extends BodyArmour(dropLevel = 32)
case object LordlyPlate extends BodyArmour(dropLevel = 35)
case object BronzePlate extends BodyArmour(dropLevel = 37)
case object BattlePlate extends BodyArmour(dropLevel = 41)
case object SunPlate extends BodyArmour(dropLevel = 45)
case object ColosseumPlate extends BodyArmour(dropLevel = 49)
case object MajesticPlate extends BodyArmour(dropLevel = 53)
case object GoldenPlate extends BodyArmour(dropLevel = 56)
case object CrusaderPlate extends BodyArmour(dropLevel = 59)
case object AstralPlate extends BodyArmour(dropLevel = 62)
case object GladiatorPlate extends BodyArmour(dropLevel = 65)
case object GloriousPlate extends BodyArmour(dropLevel = 68)

//Evasion
case object ShabbyJerkin extends BodyArmour(dropLevel = 2)
case object StrappedLeather extends BodyArmour(dropLevel = 9)
case object BuckskinTunic extends BodyArmour(dropLevel = 17)
case object WildLeather extends BodyArmour(dropLevel = 25)
case object FullLeather extends BodyArmour(dropLevel = 28)
case object SunLeather extends BodyArmour(dropLevel = 32)
case object ThiefsGarb extends BodyArmour(dropLevel = 35) {
  override def baseType: BaseType = BaseType("Thief's Garb")
}
case object EelskinTunic extends BodyArmour(dropLevel = 37)
case object FrontierLeather extends BodyArmour(dropLevel = 41)
case object GloriousLeather extends BodyArmour(dropLevel = 45)
case object CoronalLeather extends BodyArmour(dropLevel = 49)
case object CutthroatsGarb extends BodyArmour(dropLevel = 53) {
  override def baseType: BaseType = BaseType("Cutthroat's Garb")
}
case object SharkskinTunic extends BodyArmour(dropLevel = 56)
case object DestinyLeather extends BodyArmour(dropLevel = 59)
case object ExquisiteLeather extends BodyArmour(dropLevel = 62)
case object ZodiacLeather extends BodyArmour(dropLevel = 65)
case object AssassinsGarb extends BodyArmour(dropLevel = 68) {
  override def baseType: BaseType = BaseType("Assassin's Garb")
}

//ES
case object SimpleRobe extends BodyArmour(dropLevel = 3)
case object SilkenVest extends BodyArmour(dropLevel = 11)
case object ScholarsRobe extends BodyArmour(dropLevel = 18) {
  override def baseType: BaseType = BaseType("Scholar's Robe")
}
case object SilkenGarb extends BodyArmour(dropLevel = 25)
case object MagesVestment extends BodyArmour(dropLevel = 28) {
  override def baseType: BaseType = BaseType("Mage's Vestment")
}
case object SilkRobe extends BodyArmour(dropLevel = 32)
case object CabalistRegalia extends BodyArmour(dropLevel = 35)
case object SagesRobe extends BodyArmour(dropLevel = 37) {
  override def baseType: BaseType = BaseType("Sage's Robe")
}
case object SilkenWrap extends BodyArmour(dropLevel = 41)
case object ConjurersVestment extends BodyArmour(dropLevel = 45) {
  override def baseType: BaseType = BaseType("Conjurer's Vestment")
}
case object SpidersilkRobe extends BodyArmour(dropLevel = 49)
case object DestroyerRegalia extends BodyArmour(dropLevel = 53)
case object SavantsRobe extends BodyArmour(dropLevel = 56) {
  override def baseType: BaseType = BaseType("Savant's Robe")
}
case object NecromancerSilks extends BodyArmour(dropLevel = 59)
case object OccultistsVestment extends BodyArmour(dropLevel = 62) {
  override def baseType: BaseType = BaseType("Occultist's Vestment")
}
case object WidowsilkRobe extends BodyArmour(dropLevel = 65)
case object VaalRegalia extends BodyArmour(dropLevel = 68)

//Armour+Evasion
case object ScaleVest extends BodyArmour(dropLevel = 4)
case object LightBrigandine extends BodyArmour(dropLevel = 8)
case object ScaleDoublet extends BodyArmour(dropLevel = 17)
case object InfantryBrigandine extends BodyArmour(dropLevel = 21)
case object FullScaleArmour extends BodyArmour(dropLevel = 28)
case object SoldiersBrigandine extends BodyArmour(dropLevel = 32) {
  override def baseType: BaseType = BaseType("Soldier's Brigandine")
}
case object FieldLamellar extends BodyArmour(dropLevel = 35)
case object WyrmscaleDoublet extends BodyArmour(dropLevel = 38)
case object HussarBrigandine extends BodyArmour(dropLevel = 42)
case object FullWyrmscale extends BodyArmour(dropLevel = 46)
case object CommandersBrigandine extends BodyArmour(dropLevel = 50) {
  override def baseType: BaseType = BaseType("Commander's Brigandine")
}
case object BattleLamellar extends BodyArmour(dropLevel = 54)
case object DragonscaleDoublet extends BodyArmour(dropLevel = 57)
case object DesertBrigandine extends BodyArmour(dropLevel = 60)
case object FullDragonscale extends BodyArmour(dropLevel = 63)
case object GeneralsBrigandine extends BodyArmour(dropLevel = 66) {
  override def baseType: BaseType = BaseType("General's Brigandine")
}
case object TriumphantLamellar extends BodyArmour(dropLevel = 69)

//Armour+ES
case object ChainmailVest extends BodyArmour(dropLevel = 4)
case object ChainmailTunic extends BodyArmour(dropLevel = 8)
case object RingmailCoat extends BodyArmour(dropLevel = 17)
case object ChainmailDoublet extends BodyArmour(dropLevel = 21)
case object FullRingmail extends BodyArmour(dropLevel = 28)
case object FullChainmail extends BodyArmour(dropLevel = 32)
case object HolyChainmail extends BodyArmour(dropLevel = 35)
case object LatticedRingmail extends BodyArmour(dropLevel = 39)
case object CrusaderChainmail extends BodyArmour(dropLevel = 43)
case object OrnateRingmail extends BodyArmour(dropLevel = 47)
case object ChainHauberk extends BodyArmour(dropLevel = 51)
case object DevoutChainmail extends BodyArmour(dropLevel = 55)
case object LoricatedRingmail extends BodyArmour(dropLevel = 58)
case object ConquestChainmail extends BodyArmour(dropLevel = 61)
case object ElegantRingmail extends BodyArmour(dropLevel = 64)
case object SaintsHauberk extends BodyArmour(dropLevel = 67) {
  override def baseType: BaseType = BaseType("Saint's Hauberk")
}
case object SaintlyChainmail extends BodyArmour(dropLevel = 70)

//Evasion+ES
case object PaddedVest extends BodyArmour(dropLevel = 4)
case object OiledVest extends BodyArmour(dropLevel = 9)
case object PaddedJacket extends BodyArmour(dropLevel = 18)
case object OiledCoat extends BodyArmour(dropLevel = 22)
case object ScarletRaiment extends BodyArmour(dropLevel = 28)
case object WaxedGarb extends BodyArmour(dropLevel = 32)
case object BoneArmour extends BodyArmour(dropLevel = 35)
case object QuiltedJacket extends BodyArmour(dropLevel = 40)
case object SleekCoat extends BodyArmour(dropLevel = 44)
case object CrimsonRaiment extends BodyArmour(dropLevel = 48)
case object LacqueredGarb extends BodyArmour(dropLevel = 52)
case object CryptArmour extends BodyArmour(dropLevel = 56)
case object SentinelJacket extends BodyArmour(dropLevel = 59)
case object VarnishedCoat extends BodyArmour(dropLevel = 62)
case object BloodRaiment extends BodyArmour(dropLevel = 65)
case object SadistGarb extends BodyArmour(dropLevel = 68)
case object CarnalArmour extends BodyArmour(dropLevel = 71)
