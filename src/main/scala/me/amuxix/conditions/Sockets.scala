package me.amuxix.conditions

object Sockets {
  def apply(level: Int): Sockets = new Sockets(level)
}
case class Sockets(start: Int, end: Int) extends OperatorWritable[Sockets](6, "Sockets") {
  def this(value: Int) = this(value, value)

  override val min: Int = 1
  override def merge(other: Sockets): Sockets =
    Sockets(start min other.start, end max other.end)
}
