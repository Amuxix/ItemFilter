package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.syntax.flatMap._
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, darkRed, white}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object MapFragments extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] =
    NonEmptyList.of(
      provider.mapFragments.breachstones,
      provider.mapFragments.miscFragments,
      provider.mapFragments.mortalFragments,
      provider.mapFragments.prophecyFragments,
      provider.mapFragments.sacrificeFragments,
      provider.mapFragments.shaperFragments,
      provider.mapFragmentFragments.breachSplinters,
      provider.mapFragments.simulacrum,
      provider.mapFragmentFragments.simulacrumFragments
    ).flatten

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
