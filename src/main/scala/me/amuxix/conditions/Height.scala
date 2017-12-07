package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Height {
  implicit def tuple22Height(tuple: (Operator, Int)): Height = Height(tuple._1, tuple._2)
  implicit def int2Height(i: Int): Height = Height(i)

  def apply(i: Int): Height = Height("", i)
}

case class Height(op: Operator, i: Int) extends Writable {
  if (i < 1 || i > 4) throw new InvalidArgument
  def this(i: Int) = this("=", i)
  override def print: String = s"Height ${op.print}$i"
}
