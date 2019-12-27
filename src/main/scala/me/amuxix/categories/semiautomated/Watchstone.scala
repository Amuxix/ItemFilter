package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.database.Watchstones
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object Watchstone extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] = Watchstones.all

  override protected def actionForRarity: FilterRarity => Action = _ => Action(size = 40)
}
