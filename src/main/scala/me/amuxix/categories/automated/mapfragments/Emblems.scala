package me.amuxix.categories.automated.mapfragments

import cats.data.NonEmptyList
import cats.implicits.{catsStdInstancesForFuture, toNonEmptyTraverseOps}
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Color.emblemTeal
import me.amuxix.items.Item
import me.amuxix.Priced
import me.amuxix.actions.{Action, Green}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.MapFragmentFragments.emblemFragments
import me.amuxix.database.MapFragments.{emblems, metamorph}

import scala.concurrent.Future

object Emblems extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[Item]] =
    NonEmptyList.of(emblems, emblemFragments, metamorph).nonEmptyFlatSequence

  override protected def action: Priced => Action =
    AutomatedCategory.automaticAction(emblemTeal, Green)
}
