package me.amuxix.items.armour

import me.amuxix.conditions.BaseType
import me.amuxix.items.Item

sealed abstract class Boots(dropLevel: Int) extends Item(dropLevel, "Boots")

//Armour
object IronGreaves extends Boots(1)
object SteelGreaves extends Boots(9)
object PlatedGreaves extends Boots(23)
object ReinforcedGreaves extends Boots(33)
object AntiqueGreaves extends Boots(37)
object AncientGreaves extends Boots(46)
object GoliathGreaves extends Boots(54)
object VaalGreaves extends Boots(62)
object TitanGreaves extends Boots(68)

//Evasion
object RawhideBoots extends Boots(3)
object GoathideBoots extends Boots(12)
object DeerskinBoots extends Boots(22)
object NubuckBoots extends Boots(34)
object EelskinBoots extends Boots(39)
object SharkskinBoots extends Boots(44)
object ShagreenBoots extends Boots(55)
object StealthBoots extends Boots(62)
object SlinkBoots extends Boots(69)

//ES
object WoolShoes extends Boots(3)
object VelvetSlippers extends Boots(9)
object SilkSlippers extends Boots(22)
object ScholarBoots extends Boots(32)
object SatinSlippers extends Boots(38)
object SamiteSlippers extends Boots(44)
object ConjurerBoots extends Boots(53)
object ArcanistSlippers extends Boots(61)
object SorcererBoots extends Boots(67)

//Armour+Evasion
object LeatherscaleBoots extends Boots(6)
object IronscaleBoots extends Boots(18)
object BronzescaleBoots extends Boots(30)
object SteelscaleBoots extends Boots(36)
object SerpentscaleBoots extends Boots(42)
object WyrmscaleBoots extends Boots(51)
object HydrascaleBoots extends Boots(59)
object DragonscaleBoots extends Boots(65)
object TwoTonedBoots extends Boots(70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}

//Armour+ES
object ChainBoots extends Boots(5)
object RingmailBoots extends Boots(13)
object MeshBoots extends Boots(28)
object RivetedBoots extends Boots(36)
object ZealotBoots extends Boots(40)
object SoldierBoots extends Boots(49)
object LegionBoots extends Boots(58)
object CrusaderBoots extends Boots(64)
object TwoTonedBoots2 extends Boots(70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}

//Evasion+ES
object WrappedBoots extends Boots(6)
object StrappedBoots extends Boots(16)
object ClaspedBoots extends Boots(27)
object ShackledBoots extends Boots(34)
object TrapperBoots extends Boots(41)
object AmbushBoots extends Boots(47)
object CarnalBoots extends Boots(55)
object AssassinsBoots extends Boots(63) {
  override val baseType: BaseType = BaseType("Assassin's Boots")
}
object MurderBoots extends Boots(69)
object TwoTonedBoots3 extends Boots(70) {
  override val baseType: BaseType = BaseType("Two-Toned Boots")
}