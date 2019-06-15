package me.amuxix.conditions
import me.amuxix.{InvalidArgument, Mergeable, Writable}

object ExplicitMod {
  implicit def string2BaseType(string: String*): ExplicitMod =
    ExplicitMod(string: _*)
}

case class ExplicitMod(mods: String*) extends Writable with Mergeable[ExplicitMod] {
  if (mods.contains("")) throw new InvalidArgument

  override def print: String =
    s"HasExplicitMod ${mods.mkString("\"", "\" \"", "\"")}"

  override def canMerge(other: ExplicitMod): Boolean =
    true //This only depends on item class
  override def merge(other: ExplicitMod): ExplicitMod =
    //noinspection ScalaUnnecessaryParentheses
    ExplicitMod((mods ++ other.mods).distinct: _*)
}
