package me.amuxix.conditions

import me.amuxix.{InvalidArgument, Mergeable, Writable}

object ItemClass {
}

case class ItemClass(`class`: String*) extends Writable with Mergeable[ItemClass] {
  if (`class`.contains("")) throw new InvalidArgument

  override def print: String = s"Class ${`class`.mkString("\"", "\" \"", "\"")}"

  override def canMerge(other: ItemClass): Boolean = true
  override def merge(other: ItemClass): ItemClass =
    //noinspection ScalaUnnecessaryParentheses
    ItemClass((`class` ++ other.`class`).distinct: _*)
}
