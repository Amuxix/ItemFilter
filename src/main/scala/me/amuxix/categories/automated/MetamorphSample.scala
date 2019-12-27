package me.amuxix.categories.automated

import cats.data.NonEmptyList
import me.amuxix.actions.{Action, Green}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.Priced
import me.amuxix.actions.Color.legacyBlue
import me.amuxix.actions.Sound.{epic, probablyShit}
import me.amuxix.database.MetamorphSamples

import scala.concurrent.Future

object MetamorphSample extends AutomatedCategory {
  override protected def items: Future[NonEmptyList[Item]] = MetamorphSamples.all

  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(legacyBlue, probablyShit, epic, Green)
}
