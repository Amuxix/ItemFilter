package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

object Prophecy {
  implicit val show: Show[Prophecy] = prophecy => s"Prophecy ${prophecy.prophecies.mkString("\"", "\" \"", "\"")}"

  implicit val mergeable: Mergeable[Prophecy] = Mergeable.join(apply, _.prophecies)
}

case class Prophecy(prophecies: String*) {
  if (prophecies.contains("")) throw new InvalidArgument
}
