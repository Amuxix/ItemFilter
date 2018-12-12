package me.amuxix.conditions

object MapTier {
  def apply(level: Int): MapTier = new MapTier(level)
}
case class MapTier(start: Int, end: Int) extends OperatorWritable[MapTier](17, "MapTier") {
  def this(value: Int) = this(value, value)

  override def merge(other: MapTier): MapTier = MapTier(start min other.start, end max other.end)
}
