package me.amuxix.items.currency
import me.amuxix.items.Item

/**
  * Like [[Orb]] this currency can enhance items but they themselves can also be upgraded.
  */
abstract class Essence(val upgradesTo: Option[Essence]) extends Orb

object Essence {
  val essences = Seq[Item](
    RemnantOfCorruption,
    EssenceOfHorror,
    EssenceOfInsanity,
    EssenceOfDelirium,
    EssenceOfHysteria,
    DeafeningEssenceOfFear,
    DeafeningEssenceOfMisery,
    DeafeningEssenceOfAnger,
    DeafeningEssenceOfTorment,
    DeafeningEssenceOfDoubt,
    DeafeningEssenceOfHatred,
    DeafeningEssenceOfDread,
    DeafeningEssenceOfGreed,
    DeafeningEssenceOfRage,
    DeafeningEssenceOfContempt,
    DeafeningEssenceOfScorn,
    DeafeningEssenceOfZeal,
    DeafeningEssenceOfSpite,
    DeafeningEssenceOfEnvy,
    DeafeningEssenceOfSorrow,
    DeafeningEssenceOfWoe,
    DeafeningEssenceOfWrath,
    DeafeningEssenceOfAnguish,
    DeafeningEssenceOfLoathing,
    DeafeningEssenceOfSuffering,
    ShriekingEssenceOfDread,
    ShriekingEssenceOfGreed,
    ShriekingEssenceOfRage,
    ShriekingEssenceOfContempt,
    ShriekingEssenceOfScorn,
    ShriekingEssenceOfZeal,
    ShriekingEssenceOfSpite,
    ShriekingEssenceOfEnvy,
    ShriekingEssenceOfSorrow,
    ShriekingEssenceOfWoe,
    ShriekingEssenceOfWrath,
    ShriekingEssenceOfAnguish,
    ShriekingEssenceOfLoathing,
    ShriekingEssenceOfSuffering,
    ShriekingEssenceOfFear,
    ShriekingEssenceOfAnger,
    ShriekingEssenceOfTorment,
    ShriekingEssenceOfHatred,
    ShriekingEssenceOfMisery,
    ShriekingEssenceOfDoubt,
    ScreamingEssenceOfDread,
    ScreamingEssenceOfGreed,
    ScreamingEssenceOfFear,
    ScreamingEssenceOfRage,
    ScreamingEssenceOfScorn,
    ScreamingEssenceOfZeal,
    ScreamingEssenceOfEnvy,
    ScreamingEssenceOfWoe,
    ScreamingEssenceOfContempt,
    ScreamingEssenceOfAnger,
    ScreamingEssenceOfHatred,
    ScreamingEssenceOfSpite,
    ScreamingEssenceOfWrath,
    ScreamingEssenceOfLoathing,
    ScreamingEssenceOfSuffering,
    ScreamingEssenceOfTorment,
    ScreamingEssenceOfAnguish,
    ScreamingEssenceOfDoubt,
    ScreamingEssenceOfMisery,
    ScreamingEssenceOfSorrow,
    WailingEssenceOfGreed,
    WailingEssenceOfContempt,
    WailingEssenceOfAnger,
    WailingEssenceOfAnguish,
    WailingEssenceOfDoubt,
    WailingEssenceOfFear,
    WailingEssenceOfHatred,
    WailingEssenceOfLoathing,
    WailingEssenceOfRage,
    WailingEssenceOfSorrow,
    WailingEssenceOfSpite,
    WailingEssenceOfSuffering,
    WailingEssenceOfTorment,
    WailingEssenceOfWoe,
    WailingEssenceOfWrath,
    WailingEssenceOfZeal,
    WeepingEssenceOfAnger,
    WeepingEssenceOfContempt,
    WeepingEssenceOfDoubt,
    WeepingEssenceOfFear,
    WeepingEssenceOfGreed,
    WeepingEssenceOfHatred,
    WeepingEssenceOfRage,
    WeepingEssenceOfSorrow,
    WeepingEssenceOfSuffering,
    WeepingEssenceOfTorment,
    WeepingEssenceOfWoe,
    WeepingEssenceOfWrath,
    MutteringEssenceOfTorment,
    MutteringEssenceOfFear,
    MutteringEssenceOfSorrow,
    MutteringEssenceOfWoe,
    MutteringEssenceOfContempt,
    MutteringEssenceOfHatred,
    MutteringEssenceOfGreed,
    MutteringEssenceOfAnger,
    WhisperingEssenceOfHatred,
    WhisperingEssenceOfGreed,
    WhisperingEssenceOfWoe,
    WhisperingEssenceOfContempt,
  )
}

object RemnantOfCorruption extends Essence(None)
object EssenceOfHorror extends Essence(None)
object EssenceOfInsanity extends Essence(None)
object EssenceOfDelirium extends Essence(None)
object EssenceOfHysteria extends Essence(None)

object DeafeningEssenceOfFear extends Essence(None)
object DeafeningEssenceOfMisery extends Essence(None)
object DeafeningEssenceOfAnger extends Essence(None)
object DeafeningEssenceOfTorment extends Essence(None)
object DeafeningEssenceOfDoubt extends Essence(None)
object DeafeningEssenceOfHatred extends Essence(None)
object DeafeningEssenceOfDread extends Essence(None)
object DeafeningEssenceOfGreed extends Essence(None)
object DeafeningEssenceOfRage extends Essence(None)
object DeafeningEssenceOfContempt extends Essence(None)
object DeafeningEssenceOfScorn extends Essence(None)
object DeafeningEssenceOfZeal extends Essence(None)
object DeafeningEssenceOfSpite extends Essence(None)
object DeafeningEssenceOfEnvy extends Essence(None)
object DeafeningEssenceOfSorrow extends Essence(None)
object DeafeningEssenceOfWoe extends Essence(None)
object DeafeningEssenceOfWrath extends Essence(None)
object DeafeningEssenceOfAnguish extends Essence(None)
object DeafeningEssenceOfLoathing extends Essence(None)
object DeafeningEssenceOfSuffering extends Essence(None)

object ShriekingEssenceOfDread extends Essence(Some(DeafeningEssenceOfDread))
object ShriekingEssenceOfGreed extends Essence(Some(DeafeningEssenceOfGreed))
object ShriekingEssenceOfRage extends Essence(Some(DeafeningEssenceOfRage))
object ShriekingEssenceOfContempt extends Essence(Some(DeafeningEssenceOfContempt))
object ShriekingEssenceOfScorn extends Essence(Some(DeafeningEssenceOfScorn))
object ShriekingEssenceOfZeal extends Essence(Some(DeafeningEssenceOfZeal))
object ShriekingEssenceOfSpite extends Essence(Some(DeafeningEssenceOfSpite))
object ShriekingEssenceOfEnvy extends Essence(Some(DeafeningEssenceOfEnvy))
object ShriekingEssenceOfSorrow extends Essence(Some(DeafeningEssenceOfSorrow))
object ShriekingEssenceOfWoe extends Essence(Some(DeafeningEssenceOfWoe))
object ShriekingEssenceOfWrath extends Essence(Some(DeafeningEssenceOfWrath))
object ShriekingEssenceOfAnguish extends Essence(Some(DeafeningEssenceOfAnguish))
object ShriekingEssenceOfLoathing extends Essence(Some(DeafeningEssenceOfLoathing))
object ShriekingEssenceOfSuffering extends Essence(Some(DeafeningEssenceOfSuffering))
object ShriekingEssenceOfFear extends Essence(Some(DeafeningEssenceOfFear))
object ShriekingEssenceOfAnger extends Essence(Some(DeafeningEssenceOfAnger))
object ShriekingEssenceOfTorment extends Essence(Some(DeafeningEssenceOfTorment))
object ShriekingEssenceOfHatred extends Essence(Some(DeafeningEssenceOfHatred))
object ShriekingEssenceOfMisery extends Essence(Some(DeafeningEssenceOfMisery))
object ShriekingEssenceOfDoubt extends Essence(Some(DeafeningEssenceOfDoubt))

object ScreamingEssenceOfDread extends Essence(Some(ShriekingEssenceOfDread))
object ScreamingEssenceOfGreed extends Essence(Some(ShriekingEssenceOfGreed))
object ScreamingEssenceOfFear extends Essence(Some(ShriekingEssenceOfFear))
object ScreamingEssenceOfRage extends Essence(Some(ShriekingEssenceOfRage))
object ScreamingEssenceOfScorn extends Essence(Some(ShriekingEssenceOfScorn))
object ScreamingEssenceOfZeal extends Essence(Some(ShriekingEssenceOfZeal))
object ScreamingEssenceOfEnvy extends Essence(Some(ShriekingEssenceOfEnvy))
object ScreamingEssenceOfWoe extends Essence(Some(ShriekingEssenceOfWoe))
object ScreamingEssenceOfContempt extends Essence(Some(ShriekingEssenceOfContempt))
object ScreamingEssenceOfAnger extends Essence(Some(ShriekingEssenceOfAnger))
object ScreamingEssenceOfHatred extends Essence(Some(ShriekingEssenceOfHatred))
object ScreamingEssenceOfSpite extends Essence(Some(ShriekingEssenceOfSpite))
object ScreamingEssenceOfWrath extends Essence(Some(ShriekingEssenceOfWrath))
object ScreamingEssenceOfLoathing extends Essence(Some(ShriekingEssenceOfLoathing))
object ScreamingEssenceOfSuffering extends Essence(Some(ShriekingEssenceOfSuffering))
object ScreamingEssenceOfTorment extends Essence(Some(ShriekingEssenceOfTorment))
object ScreamingEssenceOfAnguish extends Essence(Some(ShriekingEssenceOfAnguish))
object ScreamingEssenceOfDoubt extends Essence(Some(ShriekingEssenceOfDoubt))
object ScreamingEssenceOfMisery extends Essence(Some(ShriekingEssenceOfMisery))
object ScreamingEssenceOfSorrow extends Essence(Some(ShriekingEssenceOfSorrow))

object WailingEssenceOfGreed extends Essence(Some(ScreamingEssenceOfGreed))
object WailingEssenceOfContempt extends Essence(Some(ScreamingEssenceOfContempt))
object WailingEssenceOfAnger extends Essence(Some(ScreamingEssenceOfAnger))
object WailingEssenceOfAnguish extends Essence(Some(ScreamingEssenceOfAnguish))
object WailingEssenceOfDoubt extends Essence(Some(ScreamingEssenceOfDoubt))
object WailingEssenceOfFear extends Essence(Some(ScreamingEssenceOfFear))
object WailingEssenceOfHatred extends Essence(Some(ScreamingEssenceOfHatred))
object WailingEssenceOfLoathing extends Essence(Some(ScreamingEssenceOfLoathing))
object WailingEssenceOfRage extends Essence(Some(ScreamingEssenceOfRage))
object WailingEssenceOfSorrow extends Essence(Some(ScreamingEssenceOfSorrow))
object WailingEssenceOfSpite extends Essence(Some(ScreamingEssenceOfSpite))
object WailingEssenceOfSuffering extends Essence(Some(ScreamingEssenceOfSuffering))
object WailingEssenceOfTorment extends Essence(Some(ScreamingEssenceOfTorment))
object WailingEssenceOfWoe extends Essence(Some(ScreamingEssenceOfWoe))
object WailingEssenceOfWrath extends Essence(Some(ScreamingEssenceOfWrath))
object WailingEssenceOfZeal extends Essence(Some(ScreamingEssenceOfZeal))

object WeepingEssenceOfAnger extends Essence(Some(WailingEssenceOfAnger))
object WeepingEssenceOfContempt extends Essence(Some(WailingEssenceOfContempt))
object WeepingEssenceOfDoubt extends Essence(Some(WailingEssenceOfDoubt))
object WeepingEssenceOfFear extends Essence(Some(WailingEssenceOfFear))
object WeepingEssenceOfGreed extends Essence(Some(WailingEssenceOfGreed))
object WeepingEssenceOfHatred extends Essence(Some(WailingEssenceOfHatred))
object WeepingEssenceOfRage extends Essence(Some(WailingEssenceOfRage))
object WeepingEssenceOfSorrow extends Essence(Some(WailingEssenceOfSorrow))
object WeepingEssenceOfSuffering extends Essence(Some(WailingEssenceOfSuffering))
object WeepingEssenceOfTorment extends Essence(Some(WailingEssenceOfTorment))
object WeepingEssenceOfWoe extends Essence(Some(WailingEssenceOfWoe))
object WeepingEssenceOfWrath extends Essence(Some(WailingEssenceOfWrath))

object MutteringEssenceOfTorment extends Essence(Some(WeepingEssenceOfTorment))
object MutteringEssenceOfFear extends Essence(Some(WeepingEssenceOfFear))
object MutteringEssenceOfSorrow extends Essence(Some(WeepingEssenceOfSorrow))
object MutteringEssenceOfWoe extends Essence(Some(WeepingEssenceOfWoe))
object MutteringEssenceOfContempt extends Essence(Some(WeepingEssenceOfContempt))
object MutteringEssenceOfHatred extends Essence(Some(WeepingEssenceOfHatred))
object MutteringEssenceOfGreed extends Essence(Some(WeepingEssenceOfGreed))
object MutteringEssenceOfAnger extends Essence(Some(WeepingEssenceOfAnger))

object WhisperingEssenceOfHatred extends Essence(Some(MutteringEssenceOfHatred))
object WhisperingEssenceOfGreed extends Essence(Some(MutteringEssenceOfGreed))
object WhisperingEssenceOfWoe extends Essence(Some(MutteringEssenceOfWoe))
object WhisperingEssenceOfContempt extends Essence(Some(MutteringEssenceOfContempt))
