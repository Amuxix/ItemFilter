package me.amuxix.conditions

import me.amuxix.{Default, InvalidArgument, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object SocketGroup extends Default[SocketGroup] {
  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = SocketGroup("")
}

case class SocketGroup(group: String) extends BaseCondition with RefEquals {
  if (group.contains("[^RBGW ]")) throw new InvalidArgument

  override def print: String = s"Socket $group"
}