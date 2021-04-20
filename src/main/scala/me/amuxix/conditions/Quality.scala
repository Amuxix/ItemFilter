package me.amuxix.conditions

object Quality {
  def apply(level: Int): Quality = new Quality(level, level)
}
case class Quality(start: Int, end: Int) extends OperatorWritable[Quality](30, "Quality") {

  override def merge(other: Quality): Quality =
    Quality(start min other.start, end max other.end)
}
