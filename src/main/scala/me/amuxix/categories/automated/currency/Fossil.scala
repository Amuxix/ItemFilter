package me.amuxix.categories.automated.currency
import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.actions.Color.delveOrange
import me.amuxix.actions.EffectColor.Brown
import me.amuxix.actions.Shape.Circle
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced

object Fossil extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] =
    Currencies.fossils
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
