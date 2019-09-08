package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.{Action, Color}
import me.amuxix.actions.EffectColor.Brown
import me.amuxix.actions.Sound.{armourKit, epic}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.{Incubators => DBIncubators}
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced

object Incubators extends AutomatedCategory {
  override protected def items: IO[NonEmptyList[Item]] = DBIncubators.all

  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(Color.incubatorOrange, armourKit, epic, Brown)
}
