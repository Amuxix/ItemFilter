package me.amuxix.items.currency
import me.amuxix.items.{Item, NoDrop}

/**
  * This marker trait represents currency that alters items is ready to use, such as Exalted Orb or Chaos Orb.
  */
trait Orb extends Currency

object Orb {
  val orbs: Seq[Item] = Seq[Item](
    EternalOrb,
    BestiaryOrb,
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
    ChaosOrb,
    BlessedOrb,
    OrbOfAlchemy,
    OrbOfFusing,
    GlassblowersBauble,
    PerandusCoin,
    OrbOfScouring,
    CartographersChisel,
    SilverCoin,
    OrbOfChance,
    ArmourersScrap,
    OrbOfTransmutation,
    JewellersOrb,
    OrbOfAlteration,
    ChromaticOrb,
    ScrollOfWisdom,
    PortalScroll,
    OrbOfAugmentation,
    BlacksmithsWhetstone,
    MasterCartographersSeal,
    JourneymanCartographersSeal,
    ApprenticeCartographersSeal,
    MasterCartographersSextant,
    JourneymanCartographersSextant,
    ApprenticeCartographersSextant,
    UnshapingOrb,
    BlessingOfChayula,
    BlessingOfEsh,
    BlessingOfUulNetol,
    BlessingOfXoph,
    BlessingOfTul,
    VialOfAwakening,
    VialOfConsequence,
    VialOfDominance,
    VialOfFate,
    VialOfSacrifice,
    VialOfSummoning,
    VialOfTheGhost,
    VialOfTheRitual,
    VialOfTranscendence,
  )
}

case object EternalOrb extends Orb with NoDrop
case object BestiaryOrb extends Orb with NoDrop


case object MirrorOfKalandra extends Orb
case object ExaltedOrb extends Orb
case object DivineOrb extends Orb

case object RegalOrb extends Orb
case object OrbOfRegret extends Orb
case object VaalOrb extends Orb
case object ChaosOrb extends Orb
case object BlessedOrb extends Orb
case object OrbOfAlchemy extends Orb
case object OrbOfFusing extends Orb
case object GemcuttersPrism extends Orb {
  override lazy val name: String = "Gemcutter's Prism"
}
case object GlassblowersBauble extends Orb {
  override lazy val name: String = "Glassblower's Bauble"
}
case object PerandusCoin extends Orb
case object OrbOfScouring extends Orb
case object CartographersChisel extends Orb {
  override lazy val name: String = "Cartographer's Chisel"
}
case object SilverCoin extends Orb
case object OrbOfChance extends Orb
case object OrbOfTransmutation extends Orb
case object ArmourersScrap extends Orb {
  override lazy val name: String = "Armourer's Scrap"
}
case object JewellersOrb extends Orb {
  override lazy val name: String = "Jeweller's Orb"
}
case object OrbOfAlteration extends Orb
case object ChromaticOrb extends Orb
case object ScrollOfWisdom extends Orb
case object PortalScroll extends Orb

case object OrbOfAugmentation extends Orb
case object BlacksmithsWhetstone extends Orb {
  override lazy val name: String = "Blacksmith's Whetstone"
}

case object MasterCartographersSeal extends Orb with NoDrop {
  override def name: String = "Master Cartographer's Seal"
}
case object JourneymanCartographersSeal extends Orb with NoDrop {
  override def name: String = "Journeyman Cartographer's Seal"
}
case object ApprenticeCartographersSeal extends Orb with NoDrop {
  override def name: String = "Apprentice Cartographer's Seal"
}
case object MasterCartographersSextant extends Orb {
  override lazy val name: String = "Master Cartographer's Sextant"
}
case object JourneymanCartographersSextant extends Orb {
  override lazy val name: String = "Journeyman Cartographer's Sextant"
}
case object ApprenticeCartographersSextant extends Orb {
  override lazy val name: String = "Apprentice Cartographer's Sextant"
}
case object UnshapingOrb extends Orb with NoDrop

case object AncientOrb extends Orb
case object OrbOfHorizons extends Orb
case object OrbOfAnnulment extends Orb
case object OrbOfBinding extends Orb
case object HarbingersOrb extends Orb {
  override lazy val name: String = "Harbinger's Orb"
}
case object EngineersOrb extends Orb {
  override lazy val name: String = "Engineer's Orb"
}

case object BlessingOfChayula extends Orb
case object BlessingOfEsh extends Orb
case object BlessingOfUulNetol extends Orb {
  override lazy val name: String = "Blessing of Uul-Netol"
}
case object BlessingOfXoph extends Orb
case object BlessingOfTul extends Orb

case object VialOfAwakening extends Orb
case object VialOfConsequence extends Orb
case object VialOfDominance extends Orb
case object VialOfFate extends Orb
case object VialOfSacrifice extends Orb
case object VialOfSummoning extends Orb
case object VialOfTheGhost extends Orb
case object VialOfTheRitual extends Orb
case object VialOfTranscendence extends Orb
