package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Influences}
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Color.{darkRed, goodYellow, white}
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object Influenced extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    Bases.allEquipment.map(_.flatMap { i =>
      val fractured: GenericItem = new GenericItem {
        override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
        override lazy val condition: Future[Condition] = i.rare.map(_.copy(fracturedItem = true))
      }

      val withInfluence = NonEmptyList.fromListUnsafe(Influences.values.toList).map { influence =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
          override lazy val condition: Future[Condition] = i.rare.map(_.copy(influence = influence))
        }
      }
      withInfluence :+ fractured
    })

  override protected def actionForRarity: FilterRarity => Action = {
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Common =>
      Action()
    case Leveling =>
      Action(size = 45, borderColor = white)
  }
}
