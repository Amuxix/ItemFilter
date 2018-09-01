package me.amuxix.conditions

import me.amuxix.{InvalidArgument, Operator, Writable}

/**
  * Created by Amuxix on 03/03/2017.
  */
object LinkedSockets {
  implicit def tuple22LinkedSockets(tuple: (Operator, Int)): LinkedSockets = LinkedSockets(tuple._1, tuple._2)
  implicit def int2LinkedSockets(int: Int): LinkedSockets = LinkedSockets(int)

  def apply(links: Int): LinkedSockets = new LinkedSockets(links)
}

case class LinkedSockets(op: Operator, links: Int) extends Writable {
  def this(links: Int) = this("=", links)
  if (links < 0 || links > 6) throw new InvalidArgument

  override def print: String = s"LinkedSockets $links"
}
