package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Width extends Default[Width] {
  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = Width(">=", 0)
}

case class Width(op: Operator, i: Int) extends BaseCondition with ValueEquals {
  if (i < 1 || i > 2) throw new InvalidArgument

  def this(i: Int) = this("=", i)

  override def print: String = s"Width ${op.print}$i"
}

