package me.amuxix.items

class IncursionItem(name: String) extends Item(name, 1, 1, "Incursion Item")

object IncursionItem {
  def apply(name: String): IncursionItem = new IncursionItem(name)

  def unapply(arg: IncursionItem): Option[String] = Some(arg.name)
}
