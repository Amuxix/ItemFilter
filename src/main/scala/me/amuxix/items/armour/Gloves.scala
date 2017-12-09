package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Gloves(dropLevel: Int) extends Item(dropLevel, "Gloves")

//Armour
object IronGauntlets extends Gloves(1)
object PlatedGauntlets extends Gloves(11)
object BronzeGauntlets extends Gloves(23)
object SteelGauntlets extends Gloves(35)
object AntiqueGauntlets extends Gloves(39)
object AncientGauntlets extends Gloves(47)
object GoliathGauntlets extends Gloves(53)
object VaalGauntlets extends Gloves(63)
object TitanGauntlets extends Gloves(69)
object SpikedGloves extends Gloves(70)

//Evasion
object RawhideGloves extends Gloves(3)
object GoathideGloves extends Gloves(9)
object DeerskinGloves extends Gloves(21)
object NubuckGloves extends Gloves(33)
object EelskinGloves extends Gloves(38)
object SharkskinGloves extends Gloves(45)
object ShagreenGloves extends Gloves(54)
object StealthGloves extends Gloves(62)
object SlinkGloves extends Gloves(70)
object GrippedGloves extends Gloves(70)

//ES
object WoolGloves extends Gloves(3)
object VelvetGloves extends Gloves(12)
object SilkGloves extends Gloves(25)
object EmbroideredGloves extends Gloves(36)
object SatinGloves extends Gloves(41)
object SamiteGloves extends Gloves(47)
object ConjurerGloves extends Gloves(55)
object ArcanistGloves extends Gloves(60)
object SorcererGloves extends Gloves(69)
object FingerlessSilkGloves extends Gloves(70)

//Armour+Evasion
object FishscaleGauntlets extends Gloves(4)
object IronscaleGauntlets extends Gloves(15)
object BronzescaleGauntlets extends Gloves(27)
object SteelscaleGauntlets extends Gloves(36)
object SerpentscaleGauntlets extends Gloves(43)
object WyrmscaleGauntlets extends Gloves(49)
object HydrascaleGauntlets extends Gloves(59)
object DragonscaleGauntlets extends Gloves(67)

//Armour+ES
object ChainGloves extends Gloves(7)
object RingmailGloves extends Gloves(19)
object MeshGloves extends Gloves(32)
object RivetedGloves extends Gloves(37)
object ZealotGloves extends Gloves(43)
object SoldierGloves extends Gloves(51)
object LegionGloves extends Gloves(57)
object CrusaderGloves extends Gloves(66)

//Evasion+ES
object WrappedMitts extends Gloves(5)
object StrappedMitts extends Gloves(16)
object ClaspedMitts extends Gloves(31)
object TrapperMitts extends Gloves(36)
object AmbushMitts extends Gloves(45)
object CarnalMitts extends Gloves(50)
object AssassinsMitts extends Gloves(58) {
  override val baseType: BaseType = BaseType("Assassin's Mitts")
}
object MurderMitts extends Gloves(67)