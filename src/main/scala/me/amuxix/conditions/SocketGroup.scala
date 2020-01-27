package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class SocketGroup(group: String) extends Writable with Mergeable[SocketGroup] {
  if (group.contains("[^RBGW ]")) throw new InvalidArgument

  override def print: String = s"SocketGroup $group"

  override def canMerge(other: SocketGroup): Boolean = this.group equalsIgnoreCase other.group

  override def merge(other: SocketGroup): SocketGroup = this
}
