package me.amuxix.conditions

import me.amuxix.Mergeable

object MapTier {
  def apply(level: Int): MapTier = new MapTier(level, level)

  implicit val mergeable: Mergeable[MapTier] = OperatorWritable.merge(apply)
}
case class MapTier(start: Int, end: Int) extends OperatorWritable[MapTier](17, "MapTier") {

  override val min: Int = 1
}
