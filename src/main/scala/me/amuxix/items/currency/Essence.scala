package me.amuxix.items.currency
import me.amuxix.conditions.Condition
import me.amuxix.items.Item

/**
  * Like [[Orb]] this currency can enhance items but they themselves can also be upgraded.
  */
abstract class Essence(val upgradesTo: Option[Essence]) extends Currency {
  override protected lazy val condition: Condition = Condition(`class` = "Essence", base = name)
}

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

case object RemnantOfCorruption extends Essence(None)
case object EssenceOfHorror extends Essence(None)
case object EssenceOfInsanity extends Essence(None)
case object EssenceOfDelirium extends Essence(None)
case object EssenceOfHysteria extends Essence(None)

case object DeafeningEssenceOfFear extends Essence(None)
case object DeafeningEssenceOfMisery extends Essence(None)
case object DeafeningEssenceOfAnger extends Essence(None)
case object DeafeningEssenceOfTorment extends Essence(None)
case object DeafeningEssenceOfDoubt extends Essence(None)
case object DeafeningEssenceOfHatred extends Essence(None)
case object DeafeningEssenceOfDread extends Essence(None)
case object DeafeningEssenceOfGreed extends Essence(None)
case object DeafeningEssenceOfRage extends Essence(None)
case object DeafeningEssenceOfContempt extends Essence(None)
case object DeafeningEssenceOfScorn extends Essence(None)
case object DeafeningEssenceOfZeal extends Essence(None)
case object DeafeningEssenceOfSpite extends Essence(None)
case object DeafeningEssenceOfEnvy extends Essence(None)
case object DeafeningEssenceOfSorrow extends Essence(None)
case object DeafeningEssenceOfWoe extends Essence(None)
case object DeafeningEssenceOfWrath extends Essence(None)
case object DeafeningEssenceOfAnguish extends Essence(None)
case object DeafeningEssenceOfLoathing extends Essence(None)
case object DeafeningEssenceOfSuffering extends Essence(None)

case object ShriekingEssenceOfDread extends Essence(Some(DeafeningEssenceOfDread))
case object ShriekingEssenceOfGreed extends Essence(Some(DeafeningEssenceOfGreed))
case object ShriekingEssenceOfRage extends Essence(Some(DeafeningEssenceOfRage))
case object ShriekingEssenceOfContempt extends Essence(Some(DeafeningEssenceOfContempt))
case object ShriekingEssenceOfScorn extends Essence(Some(DeafeningEssenceOfScorn))
case object ShriekingEssenceOfZeal extends Essence(Some(DeafeningEssenceOfZeal))
case object ShriekingEssenceOfSpite extends Essence(Some(DeafeningEssenceOfSpite))
case object ShriekingEssenceOfEnvy extends Essence(Some(DeafeningEssenceOfEnvy))
case object ShriekingEssenceOfSorrow extends Essence(Some(DeafeningEssenceOfSorrow))
case object ShriekingEssenceOfWoe extends Essence(Some(DeafeningEssenceOfWoe))
case object ShriekingEssenceOfWrath extends Essence(Some(DeafeningEssenceOfWrath))
case object ShriekingEssenceOfAnguish extends Essence(Some(DeafeningEssenceOfAnguish))
case object ShriekingEssenceOfLoathing extends Essence(Some(DeafeningEssenceOfLoathing))
case object ShriekingEssenceOfSuffering extends Essence(Some(DeafeningEssenceOfSuffering))
case object ShriekingEssenceOfFear extends Essence(Some(DeafeningEssenceOfFear))
case object ShriekingEssenceOfAnger extends Essence(Some(DeafeningEssenceOfAnger))
case object ShriekingEssenceOfTorment extends Essence(Some(DeafeningEssenceOfTorment))
case object ShriekingEssenceOfHatred extends Essence(Some(DeafeningEssenceOfHatred))
case object ShriekingEssenceOfMisery extends Essence(Some(DeafeningEssenceOfMisery))
case object ShriekingEssenceOfDoubt extends Essence(Some(DeafeningEssenceOfDoubt))

case object ScreamingEssenceOfDread extends Essence(Some(ShriekingEssenceOfDread))
case object ScreamingEssenceOfGreed extends Essence(Some(ShriekingEssenceOfGreed))
case object ScreamingEssenceOfFear extends Essence(Some(ShriekingEssenceOfFear))
case object ScreamingEssenceOfRage extends Essence(Some(ShriekingEssenceOfRage))
case object ScreamingEssenceOfScorn extends Essence(Some(ShriekingEssenceOfScorn))
case object ScreamingEssenceOfZeal extends Essence(Some(ShriekingEssenceOfZeal))
case object ScreamingEssenceOfEnvy extends Essence(Some(ShriekingEssenceOfEnvy))
case object ScreamingEssenceOfWoe extends Essence(Some(ShriekingEssenceOfWoe))
case object ScreamingEssenceOfContempt extends Essence(Some(ShriekingEssenceOfContempt))
case object ScreamingEssenceOfAnger extends Essence(Some(ShriekingEssenceOfAnger))
case object ScreamingEssenceOfHatred extends Essence(Some(ShriekingEssenceOfHatred))
case object ScreamingEssenceOfSpite extends Essence(Some(ShriekingEssenceOfSpite))
case object ScreamingEssenceOfWrath extends Essence(Some(ShriekingEssenceOfWrath))
case object ScreamingEssenceOfLoathing extends Essence(Some(ShriekingEssenceOfLoathing))
case object ScreamingEssenceOfSuffering extends Essence(Some(ShriekingEssenceOfSuffering))
case object ScreamingEssenceOfTorment extends Essence(Some(ShriekingEssenceOfTorment))
case object ScreamingEssenceOfAnguish extends Essence(Some(ShriekingEssenceOfAnguish))
case object ScreamingEssenceOfDoubt extends Essence(Some(ShriekingEssenceOfDoubt))
case object ScreamingEssenceOfMisery extends Essence(Some(ShriekingEssenceOfMisery))
case object ScreamingEssenceOfSorrow extends Essence(Some(ShriekingEssenceOfSorrow))

case object WailingEssenceOfGreed extends Essence(Some(ScreamingEssenceOfGreed))
case object WailingEssenceOfContempt extends Essence(Some(ScreamingEssenceOfContempt))
case object WailingEssenceOfAnger extends Essence(Some(ScreamingEssenceOfAnger))
case object WailingEssenceOfAnguish extends Essence(Some(ScreamingEssenceOfAnguish))
case object WailingEssenceOfDoubt extends Essence(Some(ScreamingEssenceOfDoubt))
case object WailingEssenceOfFear extends Essence(Some(ScreamingEssenceOfFear))
case object WailingEssenceOfHatred extends Essence(Some(ScreamingEssenceOfHatred))
case object WailingEssenceOfLoathing extends Essence(Some(ScreamingEssenceOfLoathing))
case object WailingEssenceOfRage extends Essence(Some(ScreamingEssenceOfRage))
case object WailingEssenceOfSorrow extends Essence(Some(ScreamingEssenceOfSorrow))
case object WailingEssenceOfSpite extends Essence(Some(ScreamingEssenceOfSpite))
case object WailingEssenceOfSuffering extends Essence(Some(ScreamingEssenceOfSuffering))
case object WailingEssenceOfTorment extends Essence(Some(ScreamingEssenceOfTorment))
case object WailingEssenceOfWoe extends Essence(Some(ScreamingEssenceOfWoe))
case object WailingEssenceOfWrath extends Essence(Some(ScreamingEssenceOfWrath))
case object WailingEssenceOfZeal extends Essence(Some(ScreamingEssenceOfZeal))

case object WeepingEssenceOfAnger extends Essence(Some(WailingEssenceOfAnger))
case object WeepingEssenceOfContempt extends Essence(Some(WailingEssenceOfContempt))
case object WeepingEssenceOfDoubt extends Essence(Some(WailingEssenceOfDoubt))
case object WeepingEssenceOfFear extends Essence(Some(WailingEssenceOfFear))
case object WeepingEssenceOfGreed extends Essence(Some(WailingEssenceOfGreed))
case object WeepingEssenceOfHatred extends Essence(Some(WailingEssenceOfHatred))
case object WeepingEssenceOfRage extends Essence(Some(WailingEssenceOfRage))
case object WeepingEssenceOfSorrow extends Essence(Some(WailingEssenceOfSorrow))
case object WeepingEssenceOfSuffering extends Essence(Some(WailingEssenceOfSuffering))
case object WeepingEssenceOfTorment extends Essence(Some(WailingEssenceOfTorment))
case object WeepingEssenceOfWoe extends Essence(Some(WailingEssenceOfWoe))
case object WeepingEssenceOfWrath extends Essence(Some(WailingEssenceOfWrath))

case object MutteringEssenceOfTorment extends Essence(Some(WeepingEssenceOfTorment))
case object MutteringEssenceOfFear extends Essence(Some(WeepingEssenceOfFear))
case object MutteringEssenceOfSorrow extends Essence(Some(WeepingEssenceOfSorrow))
case object MutteringEssenceOfWoe extends Essence(Some(WeepingEssenceOfWoe))
case object MutteringEssenceOfContempt extends Essence(Some(WeepingEssenceOfContempt))
case object MutteringEssenceOfHatred extends Essence(Some(WeepingEssenceOfHatred))
case object MutteringEssenceOfGreed extends Essence(Some(WeepingEssenceOfGreed))
case object MutteringEssenceOfAnger extends Essence(Some(WeepingEssenceOfAnger))

case object WhisperingEssenceOfHatred extends Essence(Some(MutteringEssenceOfHatred))
case object WhisperingEssenceOfGreed extends Essence(Some(MutteringEssenceOfGreed))
case object WhisperingEssenceOfWoe extends Essence(Some(MutteringEssenceOfWoe))
case object WhisperingEssenceOfContempt extends Essence(Some(MutteringEssenceOfContempt))
