package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits.toNonEmptyTraverseOps
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, darkRed, white}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.MapFragmentFragments.breachSplinters
import me.amuxix.database.MapFragments._
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.FilterRarity.Priced.{Epic, Mythic, Rare}
import me.amuxix.actions.EffectColor.{Red, White, Yellow}
import me.amuxix.actions.Shape.Triangle

object MapFragments extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] =
    NonEmptyList.of(breachstones, miscsFragments, mortalFragments, prophecyFragments, sacrificeFragments, shaperFragments, breachSplinters).nonEmptyFlatSequence

  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        borderColor = darkRed,
        backgroundColor = white,
        textColor = darkRed,
        minimapIcon = (Red, Triangle),
        beam = Red,
      )
    case Epic =>
      Action(
        borderColor = darkRed,
        textColor = darkRed,
        minimapIcon = (Yellow, Triangle),
        beam = Yellow,
      )
    case Rare =>
      Action(
        borderColor = black,
        textColor = darkRed,
        minimapIcon = (White, Triangle),
        beam = White,
      )
    case _ =>
      Action(
        backgroundColor = white,
        textColor = black,
      )
  }
}
