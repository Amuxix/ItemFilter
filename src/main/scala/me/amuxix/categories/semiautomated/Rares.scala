package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.implicits.{catsStdInstancesForFuture, toTraverseOps}
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Influences}
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
        bestFractured(bestItems),
        bestWithInfluence(bestItems),
        goodForZoneFractured(allEquipment),
        bestForZoneFractured(allEquipment),
        bestForZoneWithInfluence(allEquipment)
      ).flatSequence
    } yield rares
  }

  private def bestForZoneWithInfluence(
    allEquipment: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] = {
    Future {
      for {
        i <- allEquipment
        influence <- NonEmptyList.fromListUnsafe(Influences.values.toList)
      } yield {
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = i.conditionsOfBestRaresForZoneLevel.map(_.copy(influence = influence))
        }
      }
    }
  }

  private def bestForZoneFractured(
    allEquipment: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] = {
    Future {
      allEquipment.map { i =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = i.conditionsOfBestRaresForZoneLevel.map(_.copy(fracturedItem = true))
        }
      }
    }
  }

  private def goodForZoneFractured(
    allEquipment: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] = {
    Future {
      allEquipment.map { i =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = i.conditionsOfGoodRaresForZoneLevel.map(_.copy(fracturedItem = true))
        }
      }
    }
  }

  private def bestWithInfluence(bestItems: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] = {
    Future {
      for {
        i <- bestItems
        influence <- NonEmptyList.fromListUnsafe(Influences.values.toList)
      } yield {
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
          override lazy val condition: Future[Condition] = i.rare.map(_.copy(influence = influence))
        }
      }
    }
  }

  private def bestFractured(bestItems: NonEmptyList[CraftableBase with Corruptible]): Future[NonEmptyList[GenericItem]] =
    Future {
      bestItems.map { i =>
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
          override lazy val condition: Future[Condition] = i.rare.map(_.copy(fracturedItem = true))
        }
      }
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Leveling =>
      Action(size = 45, borderColor = white)
  }
}
