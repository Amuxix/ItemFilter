package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object SocketGroup {
  implicit def string2Sockets(group: String): SocketGroup = SocketGroup(group)
}

case class SocketGroup(group: String) extends Writable {
  if (group.contains("[^RBGW ]")) throw new InvalidArgument

  override def print: String = s"Socket $group"
}