package me.amuxix.items.currency
import me.amuxix.items.Item

/**
  * This marker trait represents currency that can be put into the map device to open portals to special zones or enhance maps.
  */
trait Fragment extends Currency

object Fragment {
  val fragments = Seq[Item](
    OfferingToTheGoddess,
    DivineVessel,
    TimewornReliquaryKey,
    ChayulasBreachstone,
    XophsBreachstone,
    EshsBreachstone,
    UulNetolsBreachstone,
    TulsBreachstone,
    FragmentOfTheHydra,
    FragmentOfTheMinotaur,
    FragmentOfThePhoenix,
    FragmentOfTheChimera,
    MortalIgnorance,
    MortalHope,
    MortalRage,
    MortalGrief,
    YrielsKey,
    EbersKey,
    InyasKey,
    VolkuursKey,
    SacrificeAtMidnight,
    SacrificeAtDawn,
    SacrificeAtDusk,
    SacrificeAtNoon,
  )
}

object OfferingToTheGoddess extends Fragment
object DivineVessel extends Fragment
object TimewornReliquaryKey extends Fragment

object ChayulasBreachstone extends Fragment
object XophsBreachstone extends Fragment
object EshsBreachstone extends Fragment
object UulNetolsBreachstone extends Fragment
object TulsBreachstone extends Fragment

object FragmentOfTheHydra extends Fragment
object FragmentOfTheMinotaur extends Fragment
object FragmentOfThePhoenix extends Fragment
object FragmentOfTheChimera extends Fragment

object MortalIgnorance extends Fragment
object MortalHope extends Fragment
object MortalRage extends Fragment
object MortalGrief extends Fragment

object YrielsKey extends Fragment
object EbersKey extends Fragment
object InyasKey extends Fragment
object VolkuursKey extends Fragment

object SacrificeAtMidnight extends Fragment
object SacrificeAtDawn extends Fragment
object SacrificeAtDusk extends Fragment
object SacrificeAtNoon extends Fragment
