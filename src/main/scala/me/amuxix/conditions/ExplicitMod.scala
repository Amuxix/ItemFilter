package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

object ExplicitMod {
  implicit val show: Show[ExplicitMod] = explicitMod => s"HasExplicitMod ${explicitMod.mods.mkString("\"", "\" \"", "\"")}"
}

case class ExplicitMod(mods: String*) extends Mergeable[ExplicitMod] {
  if (mods.contains("")) throw new InvalidArgument

  override def canMerge(other: ExplicitMod): Boolean =
    true //This only depends on item class
  override def merge(other: ExplicitMod): ExplicitMod =
    ExplicitMod((mods ++ other.mods).distinct: _*)
}
