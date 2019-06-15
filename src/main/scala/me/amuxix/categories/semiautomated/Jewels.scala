package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{FilterRarity, Leveling, Uncommon}
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object Jewels extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    Future.successful(
      NonEmptyList.of(
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] =
            Future.successful(Uncommon)
          override lazy val condition: Future[Condition] =
            Future.successful(Condition(`class` = "Jewel", rarity = GameRare))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] =
            Future.successful(Leveling)
          override lazy val condition: Future[Condition] =
            Future.successful(Condition(`class` = "Jewel"))
        },
      )
    )
  override protected def actionForRarity = {
    case Uncommon =>
      Action(size = 40)
    case _ =>
      Action(size = 35)
  }
}
