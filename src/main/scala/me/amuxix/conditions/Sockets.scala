package me.amuxix.conditions

import me.amuxix.Mergeable

object Sockets {
  def apply(level: Int): Sockets = new Sockets(level, level)

  implicit val mergeable: Mergeable[Sockets] = OperatorWritable.merge(apply)
}
case class Sockets(start: Int, end: Int) extends OperatorWritable[Sockets](6, "Sockets") {

  override val min: Int = 1
}
