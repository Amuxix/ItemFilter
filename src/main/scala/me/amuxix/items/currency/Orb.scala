package me.amuxix.items.currency
import me.amuxix.items.NoDrop

/**
  * This marker trait represents currency that alters items is ready to use, such as Exalted Orb or Chaos Orb.
  */
sealed abstract class Orb(stackSize: Int) extends Currency(stackSize)

object Orb {
  val orbs: Seq[Currency] = Seq[Currency](
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

case object EternalOrb extends Orb(10) with NoDrop
case object BestiaryOrb extends Orb(10) with NoDrop


case object MirrorOfKalandra extends Orb(10)
case object ExaltedOrb extends Orb(10)
case object DivineOrb extends Orb(10)

case object RegalOrb extends Orb(10)
case object OrbOfRegret extends Orb(40)
case object VaalOrb extends Orb(10)
case object ChaosOrb extends Orb(10)
case object BlessedOrb extends Orb(20)
case object OrbOfAlchemy extends Orb(10)
case object OrbOfFusing extends Orb(20)
case object GemcuttersPrism extends Orb(20) {
  override lazy val name: String = "Gemcutter's Prism"
}
case object GlassblowersBauble extends Orb(20) {
  override lazy val name: String = "Glassblower's Bauble"
}
case object PerandusCoin extends Orb(1000)
case object OrbOfScouring extends Orb(20)
case object CartographersChisel extends Orb(20) {
  override lazy val name: String = "Cartographer's Chisel"
}
case object SilverCoin extends Orb(30)
case object OrbOfChance extends Orb(20)
case object OrbOfTransmutation extends Orb(40)
case object ArmourersScrap extends Orb(40) {
  override lazy val name: String = "Armourer's Scrap"
}
case object JewellersOrb extends Orb(20) {
  override lazy val name: String = "Jeweller's Orb"
}
case object OrbOfAlteration extends Orb(20)
case object ChromaticOrb extends Orb(20)
case object ScrollOfWisdom extends Orb(40)
case object PortalScroll extends Orb(40)

case object OrbOfAugmentation extends Orb(30)
case object BlacksmithsWhetstone extends Orb(20) {
  override lazy val name: String = "Blacksmith's Whetstone"
}

case object MasterCartographersSeal extends Orb(10) with NoDrop {
  override def name: String = "Master Cartographer's Seal"
}
case object JourneymanCartographersSeal extends Orb(10) with NoDrop {
  override def name: String = "Journeyman Cartographer's Seal"
}
case object ApprenticeCartographersSeal extends Orb(10) with NoDrop {
  override def name: String = "Apprentice Cartographer's Seal"
}
case object MasterCartographersSextant extends Orb(10) {
  override lazy val name: String = "Master Cartographer's Sextant"
}
case object JourneymanCartographersSextant extends Orb(10) {
  override lazy val name: String = "Journeyman Cartographer's Sextant"
}
case object ApprenticeCartographersSextant extends Orb(10) {
  override lazy val name: String = "Apprentice Cartographer's Sextant"
}
case object UnshapingOrb extends Orb(10) with NoDrop

case object AncientOrb extends Orb(20)
case object OrbOfHorizons extends Orb(20)
case object OrbOfAnnulment extends Orb(20)
case object OrbOfBinding extends Orb(20)
case object HarbingersOrb extends Orb(20) {
  override lazy val name: String = "Harbinger's Orb"
}
case object EngineersOrb extends Orb(20) {
  override lazy val name: String = "Engineer's Orb"
}

case object BlessingOfChayula extends Orb(10)
case object BlessingOfEsh extends Orb(10)
case object BlessingOfUulNetol extends Orb(10) {
  override lazy val name: String = "Blessing of Uul-Netol"
}
case object BlessingOfXoph extends Orb(10)
case object BlessingOfTul extends Orb(10)

case object VialOfAwakening extends Orb(10)
case object VialOfConsequence extends Orb(10)
case object VialOfDominance extends Orb(10)
case object VialOfFate extends Orb(10)
case object VialOfSacrifice extends Orb(10)
case object VialOfSummoning extends Orb(10)
case object VialOfTheGhost extends Orb(10)
case object VialOfTheRitual extends Orb(10)
case object VialOfTranscendence extends Orb(10)
