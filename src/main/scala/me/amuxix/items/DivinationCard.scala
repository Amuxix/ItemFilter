package me.amuxix.items

class DivinationCard(name: String) extends Item(name, 1, 1, "Divination Card")

object DivinationCard {
  def apply(name: String): DivinationCard = new DivinationCard(name)

  def unapply(arg: DivinationCard): Option[String] = Some(arg.name)
}
