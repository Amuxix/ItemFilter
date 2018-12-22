package me.amuxix.categories.automated.legacy
import me.amuxix.FilterRarity
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Net extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Currencies.nets
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45, borderColor = Color.nets.darken, textColor = Color.nets.darken.darken, backgroundColor = Color.goodYellow.lighten)
}
