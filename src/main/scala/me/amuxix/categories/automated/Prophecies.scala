package me.amuxix.categories.automated
import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, prophecyPink}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Prophecies.all
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.FilterRarity.Priced.{Common, Epic, Rare, Uncommon}

object Prophecies extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] = all
  override protected def action: Priced => Action = {
    case Common =>
      Action(
        backgroundColor = black,
        textColor = prophecyPink,
      )
    case Uncommon =>
      Action(
        size = 36,
        backgroundColor = black,
        textColor = prophecyPink.darken,
        borderColor = prophecyPink.darken,
      )
    case Rare =>
      Action(
        size = 36,
        backgroundColor = black,
        textColor = prophecyPink,
        borderColor = prophecyPink,
      )
    case Epic =>
      Action(
        size = 40,
        backgroundColor = prophecyPink.lighten,
        textColor = black,
        borderColor = black,
      )
    case _ =>
      Action(
        size = 45,
        backgroundColor = prophecyPink,
        textColor = black,
        borderColor = black,
      )
  }
}
