package me.amuxix.categories.automated.currency

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions._
import me.amuxix.actions.Color.{blightBlue, blightOrange, lightGreen}
import me.amuxix.actions.Sound.{epic, myths}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.FilterRarity.Priced.{Epic, Mythic, Rare, Uncommon}
import me.amuxix.actions.EffectColor.{Green, Yellow}
import me.amuxix.actions.Shape.{Diamond, Hexagon, Star}

object Oil extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] = Currencies.oils

  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = myths,
        backgroundColor = lightGreen,
        textColor = blightBlue,
        borderColor = blightBlue,
        minimapIcon = (Green, Star),
        beam = Green,
      )
    case Epic =>
      Action(
        size = 45,
        sound = epic,
        backgroundColor = blightBlue,
        textColor = blightOrange.lighten,
        borderColor = blightOrange.lighten,
        minimapIcon = (Yellow, Star),
        beam = Yellow,
      )
    case Rare =>
      Action(
        size = 45,
        backgroundColor = blightBlue.darken,
        textColor = blightOrange,
        borderColor = blightOrange,
        minimapIcon = (Yellow, Hexagon),
        beam = Yellow,
      )
    case Uncommon =>
      Action(
        size = 45,
        backgroundColor = blightBlue.darken,
        textColor = blightOrange,
        borderColor = blightOrange,
        minimapIcon = (Yellow, Diamond),
        beam = (Yellow, true),
      )
    case _ =>
      Action(
        size = 40,
        backgroundColor = blightBlue.darken,
        textColor = blightOrange,
        borderColor = blightOrange,
      )
  }
}
