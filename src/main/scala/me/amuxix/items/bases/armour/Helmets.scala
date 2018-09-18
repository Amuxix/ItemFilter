package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.bases.Armour

sealed abstract class Helmet(dropLevel: Int) extends Armour(2, 2, dropLevel, "Helmet")

//Armour
object IronHat extends Helmet(dropLevel = 1)
object ConeHelmet extends Helmet(dropLevel = 7)
object BarbuteHelmet extends Helmet(dropLevel = 18)
object CloseHelmet extends Helmet(dropLevel = 26)
object GladiatorHelmet extends Helmet(dropLevel = 35)
object ReaverHelmet extends Helmet(dropLevel = 40)
object SiegeHelmet extends Helmet(dropLevel = 48)
object SamiteHelmet extends Helmet(dropLevel = 55)
object EzomyteBurgonet extends Helmet(dropLevel = 60)
object RoyalBurgonet extends Helmet(dropLevel = 65)
object EternalBurgonet extends Helmet(dropLevel = 69)

//Evasion
object LeatherCap extends Helmet(dropLevel = 3)
object Tricorne extends Helmet(dropLevel = 10)
object LeatherHood extends Helmet(dropLevel = 20)
object WolfPelt extends Helmet(dropLevel = 30)
object HunterHood extends Helmet(dropLevel = 41)
object NobleTricorne extends Helmet(dropLevel = 47)
object UrsinePelt extends Helmet(dropLevel = 55)
object SilkenHood extends Helmet(dropLevel = 60)
object SinnerTricorne extends Helmet(dropLevel = 64)
object LionPelt extends Helmet(dropLevel = 70)

//ES
object VineCirclet extends Helmet(dropLevel = 3)
object IronCirclet extends Helmet(dropLevel = 8)
object TortureCage extends Helmet(dropLevel = 17)
object TribalCirclet extends Helmet(dropLevel = 26)
object BoneCirclet extends Helmet(dropLevel = 34)
object LunarisCirclet extends Helmet(dropLevel = 39)
object SteelCirclet extends Helmet(dropLevel = 48)
object NecromancerCirclet extends Helmet(dropLevel = 54)
object SolarisCirclet extends Helmet(dropLevel = 59)
object MindCage extends Helmet(dropLevel = 65)
object HubrisCirclet extends Helmet(dropLevel = 69)

//Armour+Evasion
object BatteredHelm extends Helmet(dropLevel = 4)
object Sallet extends Helmet(dropLevel = 13)
object VisoredSallet extends Helmet(dropLevel = 23)
object GildedSallet extends Helmet(dropLevel = 33)
object SecutorHelm extends Helmet(dropLevel = 36)
object FencerHelm extends Helmet(dropLevel = 43)
object LacqueredHelmet extends Helmet(dropLevel = 51)
object FlutedBascinet extends Helmet(dropLevel = 58)
object PigFacedBascinet extends Helmet(dropLevel = 63) {
  override def baseType: BaseType = BaseType("Pig-Faced Bascinet")
}
object NightmareBascinet extends Helmet(dropLevel = 67)

//Armour+ES
object RustedCoif extends Helmet(dropLevel = 5)
object SoldierHelmet extends Helmet(dropLevel = 12)
object GreatHelmet extends Helmet(dropLevel = 22)
object CrusaderHelmet extends Helmet(dropLevel = 31)
object AventailHelmet extends Helmet(dropLevel = 37)
object ZealotHelmet extends Helmet(dropLevel = 44)
object GreatCrown extends Helmet(dropLevel = 53)
object MagistrateCrown extends Helmet(dropLevel = 58)
object ProphetCrown extends Helmet(dropLevel = 63)
object PraetorCrown extends Helmet(dropLevel = 68)
object BoneHelmet extends Helmet(dropLevel = 73)

//Evasion+ES
object ScareMask extends Helmet(dropLevel = 4)
object PlagueMask extends Helmet(dropLevel = 10)
object IronMask extends Helmet(dropLevel = 17)
object FestivalMask extends Helmet(dropLevel = 28)
object GoldenMask extends Helmet(dropLevel = 35)
object RavenMask extends Helmet(dropLevel = 38)
object CallousMask extends Helmet(dropLevel = 45)
object RegicideMask extends Helmet(dropLevel = 52)
object HarlequinMask extends Helmet(dropLevel = 57)
object VaalMask extends Helmet(dropLevel = 62)
object DeicideMask extends Helmet(dropLevel = 67)
