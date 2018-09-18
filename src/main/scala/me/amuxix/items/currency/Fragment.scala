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

case object OfferingToTheGoddess extends Fragment
case object DivineVessel extends Fragment
case object TimewornReliquaryKey extends Fragment

case object ChayulasBreachstone extends Fragment {
  override  val name: String = "Chayula's Breachstone"
}
case object XophsBreachstone extends Fragment {
  override  val name: String = "Xoph's Breachstone"
}
case object EshsBreachstone extends Fragment {
  override  val name: String = "Esh's Breachstone"
}
case object UulNetolsBreachstone extends Fragment {
  override  val name: String = "Uul-Netol's Breachstone"
}
case object TulsBreachstone extends Fragment {
  override  val name: String = "Tul's Breachstone"
}

case object FragmentOfTheHydra extends Fragment
case object FragmentOfTheMinotaur extends Fragment
case object FragmentOfThePhoenix extends Fragment
case object FragmentOfTheChimera extends Fragment

case object MortalIgnorance extends Fragment
case object MortalHope extends Fragment
case object MortalRage extends Fragment
case object MortalGrief extends Fragment

case object YrielsKey extends Fragment {
  override  val name: String = "Yriel's Key"
}
case object EbersKey extends Fragment {
  override  val name: String = "Eber's Key"
}
case object InyasKey extends Fragment {
  override  val name: String = "Inya's Key"
}
case object VolkuursKey extends Fragment {
  override  val name: String = "Volkuur's Key"
}

case object SacrificeAtMidnight extends Fragment
case object SacrificeAtDawn extends Fragment
case object SacrificeAtDusk extends Fragment
case object SacrificeAtNoon extends Fragment
