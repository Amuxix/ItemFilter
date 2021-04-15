package me.amuxix.categories.automated.mapfragments

import cats.data.NonEmptyList
import cats.syntax.flatMap._
import me.amuxix.actions.Color.emblemTeal
import me.amuxix.items.Item
import me.amuxix.Priced
import me.amuxix.actions.{Action, Green}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.providers.Provider

object Emblems extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = NonEmptyList.of(
    provider.mapFragmentFragments.emblemFragments,
    provider.mapFragments.emblems,
    provider.mapFragments.metamorph,
  ).flatten

  override protected def action: Priced => Action =
    AutomatedCategory.automaticAction(emblemTeal, Green)
}
