package me.amuxix.categories.automated.leagues
import me.amuxix._
import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.database.IncursionItems
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Incursion extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = IncursionItems.all

  override protected def actionForRarity(rarity: FilterRarity): Action =
    Action(
      size = 45,
      backgroundColor = Color.black,
      textColor = Color.incursionRed,
      borderColor = Color.incursionGreen,
      sound = Sound.incursion
    )
}
