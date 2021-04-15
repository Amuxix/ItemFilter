package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Maps extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = provider.maps.all.flatMap { map =>
    NonEmptyList.of(
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Epic
        override lazy val condition: Condition = map.sameTierOrUpgrade
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Rare
        override lazy val condition: Condition = map.good
      },
      map,
    )
  }

  override protected def actionForRarity: FilterRarity => Action = {
    case Mythic => Action(size = 45, sound = betterMaps, borderColor = red, minimapIcon = (Red, Square), beam = Red)
    case Epic   => Action(size = 40, sound = maps, borderColor = goodYellow, minimapIcon = (Yellow, Square), beam = Yellow)
    case Rare   => Action(borderColor = white, sound = maps, minimapIcon = (White, Square), beam = White)
    case _      => Action(sound = maps, minimapIcon = (White, Square))
  }
}
