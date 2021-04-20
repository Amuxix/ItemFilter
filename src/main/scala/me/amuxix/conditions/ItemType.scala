package me.amuxix.conditions

import cats.Show
import me.amuxix.{Mergeable, Named}

abstract class ItemType[T <: ItemType[T]] extends Mergeable[T] {
  def is: Boolean

  override def canMerge(other: T): Boolean = this.is == other.is
}

object ItemType {
  implicit def show[T <: ItemType[T]]: Show[ItemType[T]] = itemType => s"${Named.className(itemType)} ${itemType.is}"
}
