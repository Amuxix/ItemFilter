package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Sockets {
  implicit def tuple22Sockets(tuple: (Operator, Int)): Sockets = Sockets(tuple._1, tuple._2)
  implicit def int2Sockets(sockets: Int): Sockets = Sockets(sockets)

  def apply(s: Int): Sockets = new Sockets(s)
}

case class Sockets(op: Operator, sockets: Int) extends Writable {
  if (sockets < 0 || sockets > 6) throw new InvalidArgument
  def this(s: Int) = this("=", s)

  override def print: String = s"Sockets ${op.print}$sockets"
}
