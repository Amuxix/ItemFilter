package me.amuxix.items.bases.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.ItemSize
import me.amuxix.items.bases.Armour

sealed abstract class Gloves(dropLevel: Int) extends Armour(ItemSize(2, 2), dropLevel, "Gloves")

//Armour
object IronGauntlets extends Gloves(dropLevel = 1)
object PlatedGauntlets extends Gloves(dropLevel = 11)
object BronzeGauntlets extends Gloves(dropLevel = 23)
object SteelGauntlets extends Gloves(dropLevel = 35)
object AntiqueGauntlets extends Gloves(dropLevel = 39)
object AncientGauntlets extends Gloves(dropLevel = 47)
object GoliathGauntlets extends Gloves(dropLevel = 53)
object VaalGauntlets extends Gloves(dropLevel = 63)
object TitanGauntlets extends Gloves(dropLevel = 69)
object SpikedGloves extends Gloves(dropLevel = 70)

//Evasion
object RawhideGloves extends Gloves(dropLevel = 3)
object GoathideGloves extends Gloves(dropLevel = 9)
object DeerskinGloves extends Gloves(dropLevel = 21)
object NubuckGloves extends Gloves(dropLevel = 33)
object EelskinGloves extends Gloves(dropLevel = 38)
object SharkskinGloves extends Gloves(dropLevel = 45)
object ShagreenGloves extends Gloves(dropLevel = 54)
object StealthGloves extends Gloves(dropLevel = 62)
object SlinkGloves extends Gloves(dropLevel = 70)
object GrippedGloves extends Gloves(dropLevel = 70)

//ES
object WoolGloves extends Gloves(dropLevel = 3)
object VelvetGloves extends Gloves(dropLevel = 12)
object SilkGloves extends Gloves(dropLevel = 25)
object EmbroideredGloves extends Gloves(dropLevel = 36)
object SatinGloves extends Gloves(dropLevel = 41)
object SamiteGloves extends Gloves(dropLevel = 47)
object ConjurerGloves extends Gloves(dropLevel = 55)
object ArcanistGloves extends Gloves(dropLevel = 60)
object SorcererGloves extends Gloves(dropLevel = 69)
object FingerlessSilkGloves extends Gloves(dropLevel = 70)

//Armour+Evasion
object FishscaleGauntlets extends Gloves(dropLevel = 4)
object IronscaleGauntlets extends Gloves(dropLevel = 15)
object BronzescaleGauntlets extends Gloves(dropLevel = 27)
object SteelscaleGauntlets extends Gloves(dropLevel = 36)
object SerpentscaleGauntlets extends Gloves(dropLevel = 43)
object WyrmscaleGauntlets extends Gloves(dropLevel = 49)
object HydrascaleGauntlets extends Gloves(dropLevel = 59)
object DragonscaleGauntlets extends Gloves(dropLevel = 67)

//Armour+ES
object ChainGloves extends Gloves(dropLevel = 7)
object RingmailGloves extends Gloves(dropLevel = 19)
object MeshGloves extends Gloves(dropLevel = 32)
object RivetedGloves extends Gloves(dropLevel = 37)
object ZealotGloves extends Gloves(dropLevel = 43)
object SoldierGloves extends Gloves(dropLevel = 51)
object LegionGloves extends Gloves(dropLevel = 57)
object CrusaderGloves extends Gloves(dropLevel = 66)

//Evasion+ES
object WrappedMitts extends Gloves(dropLevel = 5)
object StrappedMitts extends Gloves(dropLevel = 16)
object ClaspedMitts extends Gloves(dropLevel = 31)
object TrapperMitts extends Gloves(dropLevel = 36)
object AmbushMitts extends Gloves(dropLevel = 45)
object CarnalMitts extends Gloves(dropLevel = 50)
object AssassinsMitts extends Gloves(dropLevel = 58) {
  override def baseType: BaseType = BaseType("Assassin's Mitts")
}
object MurderMitts extends Gloves(dropLevel = 67)
