package me.amuxix.categories.automated.currency
import me.amuxix.actions.Color.delveOrange
import me.amuxix.actions.{Action, Brown, Circle}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Fossils
import me.amuxix.items.Item
import me.amuxix.{FilterRarity, Priced}

import scala.concurrent.Future

object Fossil extends AutomatedCategory {
  override protected val items: Future[Seq[Item]] = Fossils.all
  override protected def action: FilterRarity with Priced => Action = { _ =>
    Action(
      size = 40,
      borderColor = delveOrange.lighten,
      backgroundColor = delveOrange.darken,
      textColor = delveOrange.lighten,
      minimapIcon = (Brown, Circle),
    )
  }
}
