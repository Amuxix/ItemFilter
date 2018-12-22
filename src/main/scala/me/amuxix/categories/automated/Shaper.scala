package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{AlwaysShow, FilterRarity}

import scala.concurrent.Future

object Shaper extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Future.successful(Seq(
    new CategoryItem(AlwaysShow) { override def condition: Condition = Condition(shaperItem = true) }
  ))
  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
