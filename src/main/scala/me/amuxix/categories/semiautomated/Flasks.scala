package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{FilterRarity, Leveling}
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, ItemLevel}
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Flasks extends SemiAutomatedCategory {
  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] =
    provider.bases.flasks.map{ flask =>
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = flask.closeToZoneLevel(provider, ItemLevel(1, flask.dropLevel + 5 max flask.dropLevel / 10), None)
      }
    }

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
