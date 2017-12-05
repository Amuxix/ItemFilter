package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Sockets extends Default[Sockets] {
  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = Sockets(">=", 0)
}

case class Sockets(op: Operator, s: Int) extends BaseCondition with ValueEquals {
  if (s < 0 || s > 6) throw new InvalidArgument
  def this(s: Int) = this("=", s)

  override def print: String = s"Sockets ${op.print}$s"
}
