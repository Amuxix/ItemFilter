package me.amuxix.categories.semiautomated.currency
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.actions.Color.prophecyPink
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Prophecy extends SemiAutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Currencies.prophecies
  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action(size = 45, backgroundColor = prophecyPink.darken, textColor = prophecyPink)
  }
}
