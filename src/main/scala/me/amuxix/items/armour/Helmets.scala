package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Helmet(dropLevel: Int) extends Item(dropLevel, "Helmet")

//Armour
object IronHat extends Helmet(1)
object ConeHelmet extends Helmet(7)
object BarbuteHelmet extends Helmet(18)
object CloseHelmet extends Helmet(26)
object GladiatorHelmet extends Helmet(35)
object ReaverHelmet extends Helmet(40)
object SiegeHelmet extends Helmet(48)
object SamiteHelmet extends Helmet(55)
object EzomyteBurgonet extends Helmet(60)
object RoyalBurgonet extends Helmet(65)
object EternalBurgonet extends Helmet(69)

//Evasion
object LeatherCap extends Helmet(3)
object Tricorne extends Helmet(10)
object LeatherHood extends Helmet(20)
object WolfPelt extends Helmet(30)
object HunterHood extends Helmet(41)
object NobleTricorne extends Helmet(47)
object UrsinePelt extends Helmet(55)
object SilkenHood extends Helmet(60)
object SinnerTricorne extends Helmet(64)
object LionPelt extends Helmet(70)

//ES
object VineCirclet extends Helmet(3)
object IronCirclet extends Helmet(8)
object TortureCage extends Helmet(17)
object TribalCirclet extends Helmet(26)
object BoneCirclet extends Helmet(34)
object LunarisCirclet extends Helmet(39)
object SteelCirclet extends Helmet(48)
object NecromancerCirclet extends Helmet(54)
object SolarisCirclet extends Helmet(59)
object MindCage extends Helmet(65)
object HubrisCirclet extends Helmet(69)

//Armour+Evasion
object BatteredHelm extends Helmet(4)
object Sallet extends Helmet(13)
object VisoredSallet extends Helmet(23)
object GildedSallet extends Helmet(33)
object SecutorHelm extends Helmet(36)
object FencerHelm extends Helmet(43)
object LacqueredHelmet extends Helmet(51)
object FlutedBascinet extends Helmet(58)
object PigFacedBascinet extends Helmet(63) {
  override val baseType: BaseType = BaseType("Pig-Faced Bascinet")
}
object NightmareBascinet extends Helmet(67)

//Armour+ES
object RustedCoif extends Helmet(5)
object SoldierHelmet extends Helmet(12)
object GreatHelmet extends Helmet(22)
object CrusaderHelmet extends Helmet(31)
object AventailHelmet extends Helmet(37)
object ZealotHelmet extends Helmet(44)
object GreatCrown extends Helmet(53)
object MagistrateCrown extends Helmet(58)
object ProphetCrown extends Helmet(63)
object PraetorCrown extends Helmet(68)
object BoneHelmet extends Helmet(73)

//Evasion+ES
object ScareMask extends Helmet(4)
object PlagueMask extends Helmet(10)
object IronMask extends Helmet(17)
object FestivalMask extends Helmet(28)
object GoldenMask extends Helmet(35)
object RavenMask extends Helmet(38)
object CallousMask extends Helmet(45)
object RegicideMask extends Helmet(52)
object HarlequinMask extends Helmet(57)
object VaalMask extends Helmet(62)
object DeicideMask extends Helmet(67)