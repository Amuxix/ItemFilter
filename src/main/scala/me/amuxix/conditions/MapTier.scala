package me.amuxix.conditions

object MapTier {
  def apply(level: Int): MapTier = new MapTier(level, level)
}
case class MapTier(start: Int, end: Int) extends OperatorWritable[MapTier](17, "MapTier") {

  override val min: Int = 1
  override def merge(other: MapTier): MapTier =
    MapTier(start min other.start, end max other.end)
}
