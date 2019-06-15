package me.amuxix.conditions
import me.amuxix.{InvalidArgument, Mergeable, Writable}

case class Prophecy(prophecies: String*) extends Writable with Mergeable[Prophecy] {
  if (prophecies.contains("")) throw new InvalidArgument

  override def print: String =
    s"Prophecy ${prophecies.mkString("\"", "\" \"", "\"")}"

  override def canMerge(other: Prophecy): Boolean =
    true //This only depends on item class
  override def merge(other: Prophecy): Prophecy =
    //noinspection ScalaUnnecessaryParentheses
    Prophecy((prophecies ++ other.prophecies).distinct: _*)
}
