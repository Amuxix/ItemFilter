package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
case class SocketGroup(group: String) extends BaseCondition {
  if (group.contains("[^RBGW ]")) throw InvalidArgumentException

  override def toString: String = super.toString + group
}
