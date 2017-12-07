package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Width {
  implicit def tuple22Width(tuple: (Operator, Int)): Width = Width(tuple._1, tuple._2)
  implicit def int2Width(i: Int): Width = Width(i)

  def apply(i: Int): Width = Width("", i)
}

case class Width(op: Operator, i: Int) extends Writable {
  if (i < 1 || i > 4) throw new InvalidArgument
  def this(i: Int) = this("=", i)
  override def print: String = s"Width ${op.print}$i"
}
