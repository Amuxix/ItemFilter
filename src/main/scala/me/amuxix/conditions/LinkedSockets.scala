package me.amuxix.conditions

import me.amuxix.{Default, InvalidArgument, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */

object LinkedSockets extends Default[LinkedSockets] {
  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = new LinkedSockets(0)
}

case class LinkedSockets(links: Int) extends BaseCondition with RefEquals {
  if (links < 0 || links > 6) throw new InvalidArgument

  override def print: String = s"LinkedSockets $links"
}