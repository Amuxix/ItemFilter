package me.amuxix.items.bases.armour

import me.amuxix.items.Size
import me.amuxix.items.bases.Armour

sealed abstract class Shield(dropLevel: Int) extends Armour(Size(2, 2), dropLevel, "Shield")

//Armour
object SplinteredTowerShield extends Shield(dropLevel = 1)
object CorrodedTowerShield extends Shield(dropLevel = 5)
object RawhideTowerShield extends Shield(dropLevel = 11)
object CedarTowerShield extends Shield(dropLevel = 17)
object CopperTowerShield extends Shield(dropLevel = 24)
object ReinforcedTowerShield extends Shield(dropLevel = 30)
object PaintedTowerShield extends Shield(dropLevel = 35)
object BuckskinTowerShield extends Shield(dropLevel = 39)
object MahoganyTowerShield extends Shield(dropLevel = 43)
object BronzeTowerShield extends Shield(dropLevel = 47)
object GirdedTowerShield extends Shield(dropLevel = 51)
object CrestedTowerShield extends Shield(dropLevel = 55)
object ShagreenTowerShield extends Shield(dropLevel = 58)
object EbonyTowerShield extends Shield(dropLevel = 61)
object EzomyteTowerShield extends Shield(dropLevel = 64)
object ColossalTowerShield extends Shield(dropLevel = 67)
object PinnacleTowerShield extends Shield(dropLevel = 70)

//Evasion
object GoathideBuckler extends Shield(dropLevel = 2)
object PineBuckler extends Shield(dropLevel = 8)
object PaintedBuckler extends Shield(dropLevel = 16)
object HammeredBuckler extends Shield(dropLevel = 23)
object WarBuckler extends Shield(dropLevel = 29)
object GildedBuckler extends Shield(dropLevel = 34)
object OakBuckler extends Shield(dropLevel = 38)
object EnameledBuckler extends Shield(dropLevel = 42)
object CorrugatedBuckler extends Shield(dropLevel = 46)
object BattleBuckler extends Shield(dropLevel = 50)
object GoldenBuckler extends Shield(dropLevel = 54)
object IronwoodBuckler extends Shield(dropLevel = 57)
object LacqueredBuckler extends Shield(dropLevel = 60)
object VaalBuckler extends Shield(dropLevel = 63)
object CrusaderBuckler extends Shield(dropLevel = 66)
object ImperialBuckler extends Shield(dropLevel = 69)

//ES
object TwigSpiritShield extends Shield(dropLevel = 3)
object YewSpiritShield extends Shield(dropLevel = 9)
object BoneSpiritShield extends Shield(dropLevel = 15)
object TarnishedSpiritShield extends Shield(dropLevel = 23)
object JinglingSpiritShield extends Shield(dropLevel = 28)
object BrassSpiritShield extends Shield(dropLevel = 33)
object WalnutSpiritShield extends Shield(dropLevel = 37)
object IvorySpiritShield extends Shield(dropLevel = 41)
object AncientSpiritShield extends Shield(dropLevel = 45)
object ChimingSpiritShield extends Shield(dropLevel = 49)
object ThoriumSpiritShield extends Shield(dropLevel = 53)
object LacewoodSpiritShield extends Shield(dropLevel = 56)
object FossilisedSpiritShield extends Shield(dropLevel = 59)
object VaalSpiritShield extends Shield(dropLevel = 62)
object HarmonicSpiritShield extends Shield(dropLevel = 65)
object TitaniumSpiritShield extends Shield(dropLevel = 68)

//Armour+Evasion
object RottedRoundShield extends Shield(dropLevel = 5)
object FirRoundShield extends Shield(dropLevel = 12)
object StuddedRoundShield extends Shield(dropLevel = 20)
object ScarletRoundShield extends Shield(dropLevel = 27)
object SplendidRoundShield extends Shield(dropLevel = 33)
object MapleRoundShield extends Shield(dropLevel = 39)
object SpikedRoundShield extends Shield(dropLevel = 45)
object CrimsonRoundShield extends Shield(dropLevel = 49)
object BaroqueRoundShield extends Shield(dropLevel = 54)
object TeakRoundShield extends Shield(dropLevel = 58)
object SpinyRoundShield extends Shield(dropLevel = 62)
object CardinalRoundShield extends Shield(dropLevel = 66)
object ElegantRoundShield extends Shield(dropLevel = 70)

//Armour+ES
object PlankKiteShield extends Shield(dropLevel = 7)
object LindenKiteShield extends Shield(dropLevel = 13)
object ReinforcedKiteShield extends Shield(dropLevel = 20)
object LayeredKiteShield extends Shield(dropLevel = 27)
object CeremonialKiteShield extends Shield(dropLevel = 34)
object EtchedKiteShield extends Shield(dropLevel = 40)
object SteelKiteShield extends Shield(dropLevel = 46)
object LaminatedKiteShield extends Shield(dropLevel = 50)
object AngelicKiteShield extends Shield(dropLevel = 55)
object BrandedKiteShield extends Shield(dropLevel = 59)
object ChampionKiteShield extends Shield(dropLevel = 62)
object MosaicKiteShield extends Shield(dropLevel = 65)
object ArchonKiteShield extends Shield(dropLevel = 68)

//Evasion+ES
object SpikedBundle extends Shield(dropLevel = 5)
object DriftwoodSpikedShield extends Shield(dropLevel = 12)
object AlloyedSpikedShield extends Shield(dropLevel = 20)
object BurnishedSpikedShield extends Shield(dropLevel = 27)
object OrnateSpikedShield extends Shield(dropLevel = 33)
object RedwoodSpikedShield extends Shield(dropLevel = 39)
object CompoundSpikedShield extends Shield(dropLevel = 45)
object PolishedSpikedShield extends Shield(dropLevel = 49)
object SovereignSpikedShield extends Shield(dropLevel = 54)
object AlderSpikedShield extends Shield(dropLevel = 58)
object EzomyteSpikedShield extends Shield(dropLevel = 62)
object MirroredSpikedShield extends Shield(dropLevel = 66)
object SupremeSpikedShield extends Shield(dropLevel = 70)
