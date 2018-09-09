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
    ScrollFragment,
  )
}

object SplinterOfChayula extends Shard[BlessingOfChayula.type](100)
object SplinterOfEsh extends Shard[BlessingOfEsh.type](100)
object SplinterOfUulNetol extends Shard[BlessingOfUulNetol.type](100)
object SplinterOfXoph extends Shard[BlessingOfXoph.type](100)
object SplinterOfTul extends Shard[BlessingOfTul.type](100)

object MirrorShard extends Shard[MirrorOfKalandra.type]
object ExaltedShard extends Shard[ExaltedOrb.type]
object AnnulmentShard extends Shard[OrbOfAnnulment.type]

object BindingShard extends Shard[OrbOfAnnulment.type]
object HorizonShard extends Shard[OrbOfAnnulment.type]
object HarbingersShard extends Shard[OrbOfAnnulment.type]
object EngineersShard extends Shard[OrbOfAnnulment.type]
object AncientShard extends Shard[OrbOfAnnulment.type]
object ChaosShard extends Shard[OrbOfAnnulment.type]
object RegalShard extends Shard[OrbOfAnnulment.type]
object ScrollFragment extends Shard[ScrollOfWisdom.type]
