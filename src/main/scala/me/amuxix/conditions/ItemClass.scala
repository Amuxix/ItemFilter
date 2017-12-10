package me.amuxix.conditions

import me.amuxix.{InvalidArgument, Writable}


object ItemClass {
  implicit def String2ItemClass(string: String*): ItemClass = ItemClass(string:_*)
}

case class ItemClass(`class`: String*) extends Writable {
  if (`class`.contains("")) throw new InvalidArgument
  override def print: String = s"Class ${`class`.mkString("\"", "\" \"", "\"")}"
}