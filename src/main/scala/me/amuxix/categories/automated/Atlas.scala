package me.amuxix.categories.automated

import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object Atlas extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Future.successful(Seq(
    new CategoryItem { override def condition: Condition = Condition(base = Seq("Steel Ring", "Opal Ring", "Crystal Belt")) }
  ))
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45)
}
