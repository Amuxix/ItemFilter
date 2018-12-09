package me.amuxix.items.currency
import me.amuxix.items.Item

/**
  * This represents parts of an [[Orb]] and can't be used on its own but rather needs
  * to be joined with other fragments of the same type before it can be used
  *
  * @param stackSize How many parts does it take to form a full piece of currency
  */
sealed abstract class Shard[O <: Orb](val stackSize: Int = 20) extends Currency

object Shard {
  val shards = Seq[Item](
    SplinterOfChayula,
    SplinterOfEsh,
    `SplinterOfUul-Netol`,
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
    ScrollFragment,
  )
}

case object SplinterOfChayula extends Shard[BlessingOfChayula.type](100)
case object SplinterOfEsh extends Shard[BlessingOfEsh.type](100)
case object `SplinterOfUul-Netol` extends Shard[BlessingOfUulNetol.type](100) {
  override lazy val name: String = "Splinter of Uul-Netol"
}
case object SplinterOfXoph extends Shard[BlessingOfXoph.type](100)
case object SplinterOfTul extends Shard[BlessingOfTul.type](100)

case object MirrorShard extends Shard[MirrorOfKalandra.type]
case object ExaltedShard extends Shard[ExaltedOrb.type]
case object AnnulmentShard extends Shard[OrbOfAnnulment.type]

case object BindingShard extends Shard[OrbOfAnnulment.type]
case object HorizonShard extends Shard[OrbOfAnnulment.type]
case object HarbingersShard extends Shard[OrbOfAnnulment.type] {
  override lazy val name: String = "Harbinger's Shard"
}
case object EngineersShard extends Shard[OrbOfAnnulment.type] {
  override lazy val name: String = "Engineer's Shard"
}
case object AncientShard extends Shard[OrbOfAnnulment.type]
case object ChaosShard extends Shard[OrbOfAnnulment.type]
case object RegalShard extends Shard[OrbOfAnnulment.type]
case object ScrollFragment extends Shard[ScrollOfWisdom.type]
