package me.amuxix.conditions

import cats.Show
import me.amuxix.Named

abstract class ItemType[T <: ItemType[T]] {
  def is: Boolean
}

object ItemType {
  implicit def show[T <: ItemType[T]]: Show[ItemType[T]] = itemType => s"${Named.className(itemType)} ${itemType.is}"
}
