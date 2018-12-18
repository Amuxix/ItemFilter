package me.amuxix.items.currency

/**
  * This represents parts of an [[Orb]] and can't be used on its own but rather needs
  * to be joined with other fragments of the same type before it can be used
  *
  * @param stackSize How many parts does it take to form a full piece of currency
  */
sealed abstract class Shard(val orb: Orb, stackSize: Int = 20) extends Currency(stackSize) with PriceFallback {
  override def fallback: Double = orb.chaosValuePerSlot.fold(0D)(_ / stackSize)
}

object Shard {
  val shards: Seq[Shard] = Seq(
    SplinterOfChayula,
    SplinterOfEsh,
    SplinterOfUulNetol,
    SplinterOfXoph,
    SplinterOfTul,
    MirrorShard,
    ExaltedShard,
    AnnulmentShard,
    BindingShard,
    HorizonShard,
    HarbingersShard,
    EngineersShard,
    AncientShard,
    ChaosShard,
    RegalShard,
    AlchemyShard,
    AlterationShard,
    TransmutationShard,
    ScrollFragment,
  )
}

case object SplinterOfChayula extends Shard(BlessingOfChayula, 100)
case object SplinterOfEsh extends Shard(BlessingOfEsh, 100)
case object SplinterOfUulNetol extends Shard(BlessingOfUulNetol, 100) {
  override lazy val name: String = "Splinter of Uul-Netol"
}
case object SplinterOfXoph extends Shard(BlessingOfXoph, 100)
case object SplinterOfTul extends Shard(BlessingOfTul, 100)

case object MirrorShard extends Shard(MirrorOfKalandra)
case object ExaltedShard extends Shard(ExaltedOrb)
case object AnnulmentShard extends Shard(OrbOfAnnulment)

case object BindingShard extends Shard(OrbOfBinding)
case object HorizonShard extends Shard(OrbOfHorizons)
case object HarbingersShard extends Shard(HarbingersOrb) {
  override lazy val name: String = "Harbinger's Shard"
}
case object EngineersShard extends Shard(EngineersOrb) {
  override lazy val name: String = "Engineer's Shard"
}
case object AncientShard extends Shard(AncientOrb)
case object ChaosShard extends Shard(ChaosOrb)
case object RegalShard extends Shard(RegalOrb)
case object AlchemyShard extends Shard(OrbOfAlchemy)
case object AlterationShard extends Shard(OrbOfAlteration)
case object TransmutationShard extends Shard(OrbOfTransmutation)
case object ScrollFragment extends Shard(ScrollOfWisdom, 5)
