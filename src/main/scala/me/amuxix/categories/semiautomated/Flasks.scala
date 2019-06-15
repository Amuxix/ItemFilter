package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{FilterRarity, Leveling}
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, ItemLevel}
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object Flasks extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    Bases.flasks.map(_.map { flask =>
      new GenericItem {
        override lazy val rarity: Future[FilterRarity] =
          Future.successful(Leveling)
        override lazy val condition: Future[Condition] = flask.closeToZoneLevel(ItemLevel(1, flask.dropLevel + 5 max flask.dropLevel / 10), None)
      }
    })

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
