package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.EffectColor.{Red, White, Yellow}
import me.amuxix.actions.Shape.Square
import me.amuxix.FilterRarity
import me.amuxix.actions.Color.{goodYellow, red, white}
import me.amuxix.actions.Sound.{betterMaps, maps}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.database.Maps.all
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.Priced.{Epic, Mythic, Rare}
import me.amuxix.actions.Action

object Maps extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    all.map(_.flatMap { map =>
      NonEmptyList.of(
        GenericItem(Epic, map.sameTierOrUpgrade),
        GenericItem(Rare, map.good),
        map,
      )
    })

  override protected def actionForRarity: FilterRarity => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = betterMaps,
        borderColor = red,
        minimapIcon = (Red, Square),
        beam = Red,
      )
    case Epic =>
      Action(
        size = 40,
        sound = maps,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Square),
        beam = Yellow,
      )
    case Rare =>
      Action(
        borderColor = white,
        sound = maps,
        minimapIcon = (White, Square),
        beam = White,
      )
    case _ =>
      Action(
        sound = maps,
        minimapIcon = (White, Square),
      )
  }
}
