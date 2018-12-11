package me.amuxix.conditions

object Quality {
  def apply(level: Int): Quality = new Quality(level)
}
case class Quality(start: Int, end: Int) extends OperatorWritable[Quality](20, "Quality") {
  def this(value: Int) = this(value, value)

  override def merge(other: Quality): Quality = Quality(start min other.start, end max other.end)
}
