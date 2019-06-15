package me.amuxix.categories.automated

import cats.data.NonEmptyList
import me.amuxix.actions.{Action, Brown, Color}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.Priced
import me.amuxix.actions.Sound.{armourKit, epic}
import me.amuxix.database.{Incubators => DBIncubators}

import scala.concurrent.Future

object Incubators extends AutomatedCategory {
  override protected def items: Future[NonEmptyList[Item]] = DBIncubators.all

  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(Color.incubatorOrange, armourKit, epic, Brown)
}
