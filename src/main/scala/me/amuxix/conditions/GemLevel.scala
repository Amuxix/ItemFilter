package me.amuxix.conditions

object GemLevel {
  def apply(level: Int): GemLevel = new GemLevel(level, level)
}

case class GemLevel(start: Int, end: Int) extends OperatorWritable[GemLevel](21, "GemLevel") {

  override val min: Int = 1
  override def merge(other: GemLevel): GemLevel =
    GemLevel(start min other.start, end max other.end)
}
