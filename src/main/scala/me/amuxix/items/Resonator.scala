package me.amuxix.items

class Resonator(name: String, val reforges: Boolean) extends Item(name, 1, 1, "Currency")

object Resonator {
  def apply(name: String, reforges: Boolean): Resonator = new Resonator(name, reforges)

  def unapply(arg: Resonator): Option[(String, Boolean)] = Some((arg.name, arg.reforges))
}
