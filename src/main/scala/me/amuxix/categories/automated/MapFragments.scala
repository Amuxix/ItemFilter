package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.implicits.{catsStdInstancesForFuture, toNonEmptyTraverseOps}
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, darkRed, white}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.MapFragmentFragments.{breachSplinters, simulacrumFragments}
import me.amuxix.database.MapFragments._
import me.amuxix.items.Item

import scala.concurrent.Future

object MapFragments extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[Item]] =
    NonEmptyList.of(breachstones, miscsFragments, mortalFragments, prophecyFragments, sacrificeFragments, shaperFragments, breachSplinters, simulacrum, simulacrumFragments).nonEmptyFlatSequence

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
