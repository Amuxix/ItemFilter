package me.amuxix.items

class Fossil(name: String) extends Item(name, 1, 1, "Currency")

object Fossil {
  def apply(name: String): Fossil = new Fossil(name)

  def unapply(arg: Fossil): Option[String] = Some(arg.name)
}
