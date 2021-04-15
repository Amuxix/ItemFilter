package me.amuxix.categories.automated.currency

import cats.data.NonEmptyList
import me.amuxix.Priced
import me.amuxix.actions.{Action, Brown, Circle}
import me.amuxix.actions.Color.delveOrange
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object Fossil extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.currencies.fossils
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
