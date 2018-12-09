package me.amuxix.categories.automated.currency

import me.amuxix._
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.Sound.{chaos, myths, rare}
import me.amuxix.actions._
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.items.GenItem
import me.amuxix.items.currency.{Orb, Shard}

object Currency extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Orb.orbs ++ Shard.shards

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
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
