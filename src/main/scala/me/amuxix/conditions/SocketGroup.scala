package me.amuxix.conditions

import cats.Show
import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class SocketGroup(group: String) extends Mergeable[SocketGroup] {
  if (group.contains("[^RBGWAD ]")) throw new InvalidArgument

  override def canMerge(other: SocketGroup): Boolean = this.group equalsIgnoreCase other.group

  override def merge(other: SocketGroup): SocketGroup = this
}

object SocketGroup {
  implicit val show: Show[SocketGroup] = socketGroup => s"SocketGroup ${socketGroup.group}"
}
