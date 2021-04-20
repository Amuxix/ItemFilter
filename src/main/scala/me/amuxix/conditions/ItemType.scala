package me.amuxix.conditions
import me.amuxix.{Mergeable, Writable}

abstract class ItemType[T <: ItemType[T]] extends Writable with Mergeable[T] {
  def is: Boolean

  override protected def print = s"${getClass.getSimpleName} $is"

  override def canMerge(other: T): Boolean = this.is == other.is
}
