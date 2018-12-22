package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{FilterRarity, Rare, Uncommon}

import scala.concurrent.Future

object Jewels extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Future.successful(Seq(
    new CategoryItem(Uncommon) { override def condition: Condition = Condition(`class` = "Jewel", rarity = GameRare) },
    new CategoryItem(Rare) { override def condition: Condition = Condition(`class` = "Jewel") },
  ))
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Rare =>
      Action(size = 40)
    case _ =>
      Action(size = 35)
  }
}
