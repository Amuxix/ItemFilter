package me.amuxix.categories.automated

import me.amuxix._
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.actions._
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.items.bases.Map.maps

object Maps extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = maps.flatMap { map =>
    Seq(
      new GenItem(Epic) { override protected def condition: Condition = map.sameTierOrUpgrade },
      new GenItem(Rare) { override protected def condition: Condition = map.good },
      map,
    )
  }
  override protected def actionForRarity(rarity: FilterRarity): Action =
  rarity match {
    case Mythic =>
      Action(
        size = 45,
        sound = redMaps,
        borderColor = red,
        minimapIcon = (Red, Square),
        beam = Red,
      )
    case Epic =>
      Action(
        size = 40,
        sound = yellowMaps,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Square),
        beam = Yellow,
      )
    case Rare =>
      Action(
        borderColor = white,
        sound = whiteMaps,
        minimapIcon = (White, Square),
        beam = White,
      )
    case _ => Action(
      sound = whiteMaps,
      minimapIcon = (White, Square),
    )
  }
}
