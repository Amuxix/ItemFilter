package me.amuxix.categories.automated.currency
import cats.data.NonEmptyList
import me.amuxix.Priced
import me.amuxix.actions.{Action, Brown, Circle}
import me.amuxix.actions.Color.delveOrange
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.Item

import scala.concurrent.Future

object Fossil extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[Item]] = Currencies.fossils
  override protected def action: Priced => Action = { _ =>
    Action(
      size = 40,
      borderColor = delveOrange.lighten,
      backgroundColor = delveOrange.darken,
      textColor = delveOrange.lighten,
      minimapIcon = (Brown, Circle),
    )
  }
}
