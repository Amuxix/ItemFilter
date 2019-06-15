package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Color.{darkRed, goodYellow, white}
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object Rares extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    for {
      bestItems <- Bases.bestItems
      allEquipment <- Bases.allEquipment
    } yield {
      val best = bestItems.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Undetermined)
            override lazy val condition: Future[Condition] =
              i.rare.map(_.copy(fracturedItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Undetermined)
            override lazy val condition: Future[Condition] =
              i.rare.map(_.copy(shaperItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Undetermined)
            override lazy val condition: Future[Condition] =
              i.rare.map(_.copy(elderItem = true))
          },
        )
      }
      val all = allEquipment.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfBestRaresForZoneLevel.map(_.copy(fracturedItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfGoodRaresForZoneLevel.map(_.copy(fracturedItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfBestRaresForZoneLevel.map(_.copy(shaperItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfGoodRaresForZoneLevel.map(_.copy(shaperItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfBestRaresForZoneLevel.map(_.copy(elderItem = true))
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] =
              Future.successful(Leveling)
            override lazy val condition: Future[Condition] =
              i.conditionsOfGoodRaresForZoneLevel.map(_.copy(elderItem = true))
          },
        )
      }

      best concatNel all
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Leveling =>
      Action(size = 45, borderColor = white)
  }
}
