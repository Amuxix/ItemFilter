package me.amuxix.categories.automated.currency
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.Essences
import me.amuxix.items.Item
import me.amuxix.{Epic, FilterRarity, Mythic, Priced}

import scala.concurrent.Future

object Essence extends AutomatedCategory {
  override protected val items: Future[Seq[Item]] = Essences.all
  override protected def action: FilterRarity with Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen,
        textColor = Color.black
      )
    case Epic =>
      Action(size = 40,
        borderColor = Color.black,
        backgroundColor = Color.slimeGreen.darken,
        textColor = Color.black
      )
    case _ =>
      Action(
        textColor = Color.slimeGreen
      )
  }
}
