package me.amuxix.conditions

import me.amuxix.{Default, InvalidArgument, Operator, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Height extends Default[Height]{
  implicit def int2Height(i: Int): Height = Height(i)

  def apply(i: Int): Height = Height("", i)
  override val default: Height = 0
}

case class Height(op: Operator, i: Int) extends BaseCondition with RefEquals {
  if (i < 1 || i > 4) throw new InvalidArgument
  def this(i: Int) = this("=", i)
  override def print: String = s"Height ${op.print}$i"
}
