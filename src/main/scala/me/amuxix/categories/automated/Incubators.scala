package me.amuxix.categories.automated

import cats.data.NonEmptyList
import me.amuxix.actions.{Action, Brown, Color}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.Priced
import me.amuxix.actions.Sound.{armourKit, epic}
import me.amuxix.providers.Provider

object Incubators extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.incubators.all

  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(Color.incubatorOrange, armourKit, epic, Brown)
}
