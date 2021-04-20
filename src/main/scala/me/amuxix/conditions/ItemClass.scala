package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

object ItemClass {
  implicit val show: Show[ItemClass] = itemClass => s"Class ${itemClass.`class`.mkString("\"", "\" \"", "\"")}"
}

case class ItemClass(`class`: String*) extends Mergeable[ItemClass] {
  if (`class`.contains("")) throw new InvalidArgument

  override def canMerge(other: ItemClass): Boolean = true
  override def merge(other: ItemClass): ItemClass =
    //noinspection ScalaUnnecessaryParentheses
    ItemClass((`class` ++ other.`class`).distinct: _*)
}
