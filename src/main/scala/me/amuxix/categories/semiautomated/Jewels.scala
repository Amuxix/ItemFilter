package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{Rare, Uncommon}
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object Jewels extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenItem]] = Future.successful(
    NonEmptyList.fromListUnsafe(List(
      new CategoryItem(Uncommon) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Jewel", rarity = GameRare)) },
      new CategoryItem(Rare) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Jewel")) },
    ))
  )
  override protected def actionForRarity = {
    case Rare =>
      Action(size = 40)
    case _ =>
      Action(size = 35)
  }
}
