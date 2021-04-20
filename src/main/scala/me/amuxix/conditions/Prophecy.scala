package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

case class Prophecy(prophecies: String*) extends Mergeable[Prophecy] {
  if (prophecies.contains("")) throw new InvalidArgument

  override def canMerge(other: Prophecy): Boolean =
    true //This only depends on item class
  override def merge(other: Prophecy): Prophecy =
    //noinspection ScalaUnnecessaryParentheses
    Prophecy((prophecies ++ other.prophecies).distinct: _*)
}

object Prophecy {
  implicit val show: Show[Prophecy] = prophecy => s"Prophecy ${prophecy.prophecies.mkString("\"", "\" \"", "\"")}"
}
