package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
object LinkedSockets {
  def apply(level: Int): LinkedSockets = new LinkedSockets(level)
}
case class LinkedSockets(start: Int, end: Int) extends OperatorWritable[LinkedSockets](6, "LinkedSockets") {
  def this(value: Int) = this(value, value)

  override def merge(other: LinkedSockets): LinkedSockets =
    LinkedSockets(start min other.start, end max other.end)
}
