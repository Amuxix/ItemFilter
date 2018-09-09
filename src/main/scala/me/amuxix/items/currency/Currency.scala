package me.amuxix.items.currency

import me.amuxix._
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.Sound._
import me.amuxix.actions._
import me.amuxix.conditions.ItemClass
import me.amuxix.items.currency.delve.{Fossil, Resonator}
import me.amuxix.items.{Item, ItemSize}

/**
  * This is the parent of all currency marker traits.
  */
abstract class Currency extends Item(ItemSize(1, 1)) {
  override val `class`: Option[ItemClass] = "Currency"
  override def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Mythic =>
      Action(
        size = 45,
        sound = myths,
        backgroundColor = lightGreen,
        textColor = black,
        borderColor = black,
        minimapIcon = (Green, Star),
        beam = Green,
      )
    case Epic =>
      Action(
        size = 45,
        sound = chaos,
        backgroundColor = black,
        textColor = goodYellow,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Star),
        beam = Yellow,
      )
    case Rare =>
      Action(
        size = 45,
        sound = rare,
        backgroundColor = black,
        textColor = goodYellow.lighten,
        borderColor = goodYellow.lighten,
        minimapIcon = (Yellow, Hexagon),
        beam = (Yellow, true),
      )
    case Uncommon =>
      Action(
        size = 45,
        backgroundColor = black,
        textColor = goodYellow.lighten,
        borderColor = goodYellow.lighten,
        beam = (Yellow, true),
      )
    case _ => Action(size = 40, backgroundColor = black, textColor = goodYellow.lighten)
  }
}

object Currency {
  val currency: Seq[Item] =
    Fossil.fossils ++
      Resonator.resonators ++
      Essence.essences ++
      Fragment.fragments ++
      Orb.orbs ++
      Shard.shards
}
