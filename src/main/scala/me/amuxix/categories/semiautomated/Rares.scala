package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.implicits.{catsStdInstancesForFuture, toTraverseOps}
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Color.{darkRed, goodYellow, white}
import me.amuxix.database.Bases
import me.amuxix.items.{Corruptible, CraftableBase, GenericItem}

import scala.concurrent.Future

object Rares extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] = {
    for {
      bestItems <- Bases.bestItems
      allEquipment <- Bases.allEquipment
      rares <- NonEmptyList.of(
        best(bestItems),
        bestForZone(allEquipment),
        goodForZone(allEquipment),
      ).flatSequence
    } yield rares
  }

  private def best(bestItems: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] =
    Future {
      bestItems.flatMap { i =>
        val topRare: GenericItem = new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
          override lazy val condition: Future[Condition] = i.topRare
        }
        val rare: GenericItem = new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Common)
          override lazy val condition: Future[Condition] = i.rare
        }
        NonEmptyList.of(rare, topRare)
      }
    }


  def bestForZone(allEquipment: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] =
    Future {
      allEquipment.map { i =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = i.conditionsOfBestRaresForZoneLevel
        }
      }
    }

  private def goodForZone(allEquipment: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] =
    Future {
      allEquipment.map { i =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = i.conditionsOfGoodRaresForZoneLevel
        }
      }
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Common =>
      Action()
    case Leveling =>
      Action(size = 45, borderColor = white)
  }
}
