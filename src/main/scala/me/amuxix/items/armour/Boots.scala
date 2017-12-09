package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Armour

sealed abstract class Boots(dropLevel: Int) extends Armour(dropLevel, "Boots")

//Armour
object IronGreaves extends Boots(dropLevel = 1)
object SteelGreaves extends Boots(dropLevel = 9)
object PlatedGreaves extends Boots(dropLevel = 23)
object ReinforcedGreaves extends Boots(dropLevel = 33)
object AntiqueGreaves extends Boots(dropLevel = 37)
object AncientGreaves extends Boots(dropLevel = 46)
object GoliathGreaves extends Boots(dropLevel = 54)
object VaalGreaves extends Boots(dropLevel = 62)
object TitanGreaves extends Boots(dropLevel = 68)

//Evasion
object RawhideBoots extends Boots(dropLevel = 3)
object GoathideBoots extends Boots(dropLevel = 12)
object DeerskinBoots extends Boots(dropLevel = 22)
object NubuckBoots extends Boots(dropLevel = 34)
object EelskinBoots extends Boots(dropLevel = 39)
object SharkskinBoots extends Boots(dropLevel = 44)
object ShagreenBoots extends Boots(dropLevel = 55)
object StealthBoots extends Boots(dropLevel = 62)
object SlinkBoots extends Boots(dropLevel = 69)

//ES
object WoolShoes extends Boots(dropLevel = 3)
object VelvetSlippers extends Boots(dropLevel = 9)
object SilkSlippers extends Boots(dropLevel = 22)
object ScholarBoots extends Boots(dropLevel = 32)
object SatinSlippers extends Boots(dropLevel = 38)
object SamiteSlippers extends Boots(dropLevel = 44)
object ConjurerBoots extends Boots(dropLevel = 53)
object ArcanistSlippers extends Boots(dropLevel = 61)
object SorcererBoots extends Boots(dropLevel = 67)

//Armour+Evasion
object LeatherscaleBoots extends Boots(dropLevel = 6)
object IronscaleBoots extends Boots(dropLevel = 18)
object BronzescaleBoots extends Boots(dropLevel = 30)
object SteelscaleBoots extends Boots(dropLevel = 36)
object SerpentscaleBoots extends Boots(dropLevel = 42)
object WyrmscaleBoots extends Boots(dropLevel = 51)
object HydrascaleBoots extends Boots(dropLevel = 59)
object DragonscaleBoots extends Boots(dropLevel = 65)
object TwoTonedBoots extends Boots(dropLevel = 70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}

//Armour+ES
object ChainBoots extends Boots(dropLevel = 5)
object RingmailBoots extends Boots(dropLevel = 13)
object MeshBoots extends Boots(dropLevel = 28)
object RivetedBoots extends Boots(dropLevel = 36)
object ZealotBoots extends Boots(dropLevel = 40)
object SoldierBoots extends Boots(dropLevel = 49)
object LegionBoots extends Boots(dropLevel = 58)
object CrusaderBoots extends Boots(dropLevel = 64)
object TwoTonedBoots2 extends Boots(dropLevel = 70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}

//Evasion+ES
object WrappedBoots extends Boots(dropLevel = 6)
object StrappedBoots extends Boots(dropLevel = 16)
object ClaspedBoots extends Boots(dropLevel = 27)
object ShackledBoots extends Boots(dropLevel = 34)
object TrapperBoots extends Boots(dropLevel = 41)
object AmbushBoots extends Boots(dropLevel = 47)
object CarnalBoots extends Boots(dropLevel = 55)
object AssassinsBoots extends Boots(dropLevel = 63) {
  override val baseType: BaseType = BaseType("Assassin's Boots")
}
object MurderBoots extends Boots(dropLevel = 69)
object TwoTonedBoots3 extends Boots(dropLevel = 70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}