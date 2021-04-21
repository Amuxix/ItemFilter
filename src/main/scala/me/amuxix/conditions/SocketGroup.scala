package me.amuxix.conditions

import cats.Show
import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object SocketGroup {
  implicit val show: Show[SocketGroup] = socketGroup => s"SocketGroup ${socketGroup.group}"

  implicit val mergeable: Mergeable[SocketGroup] = new Mergeable[SocketGroup] {
    override def canMerge(one: SocketGroup, other: SocketGroup): Boolean = one.group equalsIgnoreCase other.group

    override def merge(one: SocketGroup, other: SocketGroup): SocketGroup = one
  }
}

case class SocketGroup(group: String) {
  if (group.contains("[^RBGWAD ]")) throw new InvalidArgument
}
