package me.amuxix.categories.automated
import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, prophecyPink}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object Prophecies extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.prophecies.all
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
