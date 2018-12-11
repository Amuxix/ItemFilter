package me.amuxix.conditions
import me.amuxix.{InvalidArgument, Writable}

object ExplicitMod {
  implicit def string2BaseType(string: String*): ExplicitMod = ExplicitMod(string: _*)
}

case class ExplicitMod(mods: String*) extends Writable {
  if (mods.contains("")) throw new InvalidArgument

  override def print: String = s"HasExplicitMod ${mods.mkString("\"", "\" \"", "\"")}"
}