package me.amuxix.items

sealed abstract class IncursionItem extends Item(1, 1, "Incursion Item") with NoPrice

object IncursionItem {
  val incursionItems: Seq[IncursionItem] = Seq(
    FlashpowderKeg,
    StoneOfPassage
  )
}

case object FlashpowderKeg extends IncursionItem
case object StoneOfPassage extends IncursionItem
