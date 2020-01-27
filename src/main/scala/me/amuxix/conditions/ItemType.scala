package me.amuxix.conditions
import me.amuxix.{Mergeable, Writable}

abstract class ItemType[T <: ItemType[T]](val _is: Boolean) extends Writable with Mergeable[T] {
  override protected def print = s"${getClass.getSimpleName} ${_is}"

  override def canMerge(other: T): Boolean = this._is == other._is
}
