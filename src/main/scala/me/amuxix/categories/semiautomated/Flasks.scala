package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.ItemLevel
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.Priced.Leveling

object Flasks extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    Bases.flasks.map(_.map { flask =>
      GenericItem(Leveling, flask.closeToZoneLevel(ItemLevel(1, flask.dropLevel + 5 max flask.dropLevel / 10), None))
    })

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
