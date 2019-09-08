package me.amuxix.categories.automated.mapfragments

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits.toNonEmptyTraverseOps
import me.amuxix.actions.Action
import me.amuxix.actions.Color.emblemTeal
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.MapFragmentFragments.emblemFragments
import me.amuxix.database.MapFragments.emblems
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.actions.EffectColor.Green

object Emblems extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] =
    NonEmptyList.of(emblems, emblemFragments).nonEmptyFlatSequence

  override protected def action: Priced => Action =
    AutomatedCategory.automaticAction(emblemTeal, Green)
}
