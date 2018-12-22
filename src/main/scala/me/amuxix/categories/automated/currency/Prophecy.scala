package me.amuxix.categories.automated.currency
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.actions.Color.prophecyPink
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Prophecy extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Currencies.prophecies
  override protected def actionForRarity(rarity:  FilterRarity): Action = Action(size = 45, backgroundColor = prophecyPink.darken, textColor = prophecyPink)
}
