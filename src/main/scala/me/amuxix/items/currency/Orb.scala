package me.amuxix.items.currency
import me.amuxix.items.Item

/**
  * This marker trait represents currency that alters items is ready to use, such as Exalted Orb or Chaos Orb.
  */
trait Orb extends Currency

object Orb {
  val orbs = Seq[Item](
    MirrorOfKalandra,
    ExaltedOrb,
    AncientOrb,
    HarbingersOrb,
    DivineOrb,
    OrbOfAnnulment,
    EngineersOrb,
    OrbOfHorizons,
    RegalOrb,
    OrbOfBinding,
    GemcuttersPrism,
    OrbOfRegret,
    VaalOrb,
    BlessedOrb,
    OrbOfAlchemy,
    OrbOfFusing,
    GlassblowersBauble,
    PerandusCoin,
    OrbOfScouring,
    CartographersChisel,
    SilverCoin,
    OrbOfChance,
    JewellersOrb,
    OrbOfAlteration,
    ChromaticOrb,
    ScrollOfWisdom,
    PortalScroll,
    OrbOfAugmentation,
    BlacksmithsWhetstone,
    MasterCartographersSextant,
    JourneymanCartographersSextant,
    ApprenticeCartographersSextant,
    BlessingOfChayula,
    BlessingOfEsh,
    BlessingOfUulNetol,
    BlessingOfXoph,
    BlessingOfTul,
  )
}

case object MirrorOfKalandra extends Orb
case object ExaltedOrb extends Orb
case object AncientOrb extends Orb
case object HarbingersOrb extends Orb {
  override val name: String = "Harbinger's Orb"
}
case object DivineOrb extends Orb
case object OrbOfAnnulment extends Orb
case object EngineersOrb extends Orb {
  override val name: String = "Engineer's Orb"
}
case object OrbOfHorizons extends Orb
case object RegalOrb extends Orb
case object OrbOfBinding extends Orb
case object GemcuttersPrism extends Orb {
  override val name: String = "Gemcutter's Prism"
}
case object OrbOfRegret extends Orb
case object VaalOrb extends Orb
case object BlessedOrb extends Orb
case object OrbOfAlchemy extends Orb
case object OrbOfFusing extends Orb
case object GlassblowersBauble extends Orb {
  override val name: String = "Glassblower's Bauble"
}
case object PerandusCoin extends Orb
case object OrbOfScouring extends Orb
case object CartographersChisel extends Orb {
  override val name: String = "Cartographer's Chisel"
}
case object SilverCoin extends Orb
case object OrbOfChance extends Orb
case object JewellersOrb extends Orb {
  override val name: String = "Jeweller's Orb"
}
case object OrbOfAlteration extends Orb
case object ChromaticOrb extends Orb
case object ScrollOfWisdom extends Orb
case object PortalScroll extends Orb

case object OrbOfAugmentation extends Orb
case object BlacksmithsWhetstone extends Orb {
  override val name: String = "Blacksmith's Whetstone"
}

case object MasterCartographersSextant extends Orb {
  override val name: String = "Master Cartographer's Sextant"
}
case object JourneymanCartographersSextant extends Orb {
  override val name: String = "Journeyman Cartographer's Sextant"
}
case object ApprenticeCartographersSextant extends Orb {
  override val name: String = "Apprentice Cartographer's Sextant"
}

case object BlessingOfChayula extends Orb
case object BlessingOfEsh extends Orb
case object BlessingOfUulNetol extends Orb {
  override val name: String = "Blessing Of UUl-Netol"
}
case object BlessingOfXoph extends Orb
case object BlessingOfTul extends Orb
