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

object MirrorOfKalandra extends Orb
object ExaltedOrb extends Orb
object AncientOrb extends Orb
object HarbingersOrb extends Orb
object DivineOrb extends Orb
object OrbOfAnnulment extends Orb
object EngineersOrb extends Orb
object OrbOfHorizons extends Orb
object RegalOrb extends Orb
object OrbOfBinding extends Orb
object GemcuttersPrism extends Orb
object OrbOfRegret extends Orb
object VaalOrb extends Orb
object BlessedOrb extends Orb
object OrbOfAlchemy extends Orb
object OrbOfFusing extends Orb
object GlassblowersBauble extends Orb
object PerandusCoin extends Orb
object OrbOfScouring extends Orb
object CartographersChisel extends Orb
object SilverCoin extends Orb
object OrbOfChance extends Orb
object JewellersOrb extends Orb
object OrbOfAlteration extends Orb
object ChromaticOrb extends Orb
object ScrollOfWisdom extends Orb
object PortalScroll extends Orb

object OrbOfAugmentation extends Orb
object BlacksmithsWhetstone extends Orb

object MasterCartographersSextant extends Orb
object JourneymanCartographersSextant extends Orb
object ApprenticeCartographersSextant extends Orb

object BlessingOfChayula extends Orb
object BlessingOfEsh extends Orb
object BlessingOfUulNetol extends Orb
object BlessingOfXoph extends Orb
object BlessingOfTul extends Orb
