package me.amuxix.conditions

object Sockets {
  def apply(level: Int): Sockets = new Sockets(level, level)
}
case class Sockets(start: Int, end: Int) extends OperatorWritable[Sockets](6, "Sockets") {

  override val min: Int = 1
  override def merge(other: Sockets): Sockets =
    Sockets(start min other.start, end max other.end)
}
