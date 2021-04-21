package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

object ItemClass {
  implicit val show: Show[ItemClass] = itemClass => s"Class ${itemClass.`class`.mkString("\"", "\" \"", "\"")}"

  implicit val mergeable: Mergeable[ItemClass] = Mergeable.join(apply, _.`class`)
}

case class ItemClass(`class`: String*) {
  if (`class`.contains("")) throw new InvalidArgument
}
