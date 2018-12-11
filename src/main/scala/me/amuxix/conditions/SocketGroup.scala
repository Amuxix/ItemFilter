package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class SocketGroup(group: String) extends Writable {
  if (group.contains("[^RBGW ]")) throw new InvalidArgument

  override def print: String = s"SocketGroup $group"
}
