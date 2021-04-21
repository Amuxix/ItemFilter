package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

object ExplicitMod {
  implicit val show: Show[ExplicitMod] = explicitMod => s"HasExplicitMod ${explicitMod.mods.mkString("\"", "\" \"", "\"")}"

  implicit val mergeable: Mergeable[ExplicitMod] = Mergeable.join(apply, _.mods)
}

case class ExplicitMod(mods: String*) {
  if (mods.contains("")) throw new InvalidArgument
}
