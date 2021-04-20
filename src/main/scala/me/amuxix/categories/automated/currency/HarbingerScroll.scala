package me.amuxix.categories.automated.currency

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, darkRed, lightGreen, purple}
import me.amuxix.actions.Sound.{epic, myths}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object HarbingerScroll extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.currencies.harbingerScrolls

  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = myths,
        backgroundColor = lightGreen,
        textColor = purple,
        borderColor = darkRed,
        minimapIcon = (Green, Star),
        beam = Green,
      )
    case Epic =>
      Action(
        size = 45,
        sound = epic,
        backgroundColor = black,
        textColor = purple.lighten,
        borderColor = darkRed.lighten,
        minimapIcon = (Yellow, Star),
        beam = Yellow,
      )
    case Rare =>
      Action(
        size = 45,
        backgroundColor = black,
        textColor = purple,
        borderColor = darkRed,
        minimapIcon = (Yellow, Hexagon),
        beam = Yellow,
      )
    case Uncommon =>
      Action(
        size = 45,
        backgroundColor = black,
        textColor = purple,
        borderColor = darkRed,
        minimapIcon = (Yellow, Diamond),
        beam = (Yellow, true),
      )
    case _ =>
      Action(
        size = 40,
        backgroundColor = black,
        textColor = purple,
        borderColor = darkRed,
      )
  }
}
