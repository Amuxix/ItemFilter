package me.amuxix.conditions
import me.amuxix.{InvalidArgument, Operator, Writable}

object MapTier {
  def apply(tier: Int): MapTier = new MapTier(tier)
}

case class MapTier(op: Operator, tier: Int) extends Writable {
  if (tier < 1 || tier > 16) throw new InvalidArgument
  def this(tier: Int) = this("=", tier)

  override def print: String = s"MapTier ${op.print}$tier"
}
