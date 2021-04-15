package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Watchstone extends SemiAutomatedCategory {
  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = provider.watchstones.all

  override protected def actionForRarity: FilterRarity => Action = _ => Action(size = 40)
}
