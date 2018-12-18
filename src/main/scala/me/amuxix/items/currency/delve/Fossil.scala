package me.amuxix.items.currency.delve
import me.amuxix.items.currency.Currency

sealed abstract class Fossil extends Currency(1)

object Fossil {
  val fossils: Seq[Fossil] = Seq(
    FracturedFossil,
    FacetedFossil,
    GlyphicFossil,
    HollowFossil,
    ShudderingFossil,
    TangledFossil,
    BloodstainedFossil,
    GildedFossil,
    PrismaticFossil,
    CorrodedFossil,
    SanctifiedFossil,
    EncrustedFossil,
    LucentFossil,
    BoundFossil,
    EnchantedFossil,
    AethericFossil,
    PerfectFossil,
    SerratedFossil,
    PristineFossil,
    DenseFossil,
    JaggedFossil,
    MetallicFossil,
    ScorchedFossil,
    AberrantFossil,
    FrigidFossil,
  )
}

case object FracturedFossil extends Fossil
case object FacetedFossil extends Fossil
case object GlyphicFossil extends Fossil
case object HollowFossil extends Fossil
case object ShudderingFossil extends Fossil
case object TangledFossil extends Fossil
case object BloodstainedFossil extends Fossil
case object GildedFossil extends Fossil
case object PrismaticFossil extends Fossil
case object CorrodedFossil extends Fossil
case object SanctifiedFossil extends Fossil
case object EncrustedFossil extends Fossil
case object LucentFossil extends Fossil
case object BoundFossil extends Fossil
case object EnchantedFossil extends Fossil
case object AethericFossil extends Fossil
case object PerfectFossil extends Fossil
case object SerratedFossil extends Fossil
case object PristineFossil extends Fossil
case object DenseFossil extends Fossil
case object JaggedFossil extends Fossil
case object MetallicFossil extends Fossil
case object ScorchedFossil extends Fossil
case object AberrantFossil extends Fossil
case object FrigidFossil extends Fossil
