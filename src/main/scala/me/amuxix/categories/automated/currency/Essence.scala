package me.amuxix.categories.automated.currency
import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Essences
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.FilterRarity.Priced.{Epic, Mythic}

object Essence extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] = Essences.all
  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen,
        textColor = Color.black
      )
    case Epic =>
      Action(size = 40, borderColor = Color.black, backgroundColor = Color.slimeGreen.darken, textColor = Color.black)
    case _ =>
      Action(
        textColor = Color.slimeGreen
      )
  }
}
