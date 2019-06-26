package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{AlwaysHide, FilterRarity, Leveling}
import me.amuxix.ItemFilter._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem

import scala.concurrent.Future

object LevelingCategory extends SemiAutomatedCategory {
  private val itemClasses = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    Bases.allEquipment.map { allEquipment =>
      val closeToZone = allEquipment.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfBestRaresForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          },
          new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfGoodRaresForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          },
          new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfBestWhitesForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(AlwaysHide)
          },
        )
      }
      val leveling = NonEmptyList.of(
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.normalItems), linkedSockets = 3))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.magicItems), linkedSockets = 4))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.fourLinkRare), linkedSockets = 4, rarity = GameRare))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Belt", itemLevel = (1, cutoffs.normalItems)))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = itemClasses, itemLevel = (1, cutoffs.normalItems), rarity = Normal))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = itemClasses, itemLevel = (1, cutoffs.magicItems), rarity = Magic))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = config.accessoriesClasses, rarity = GameRare, itemLevel = (1, 60)))
        },
      )
      closeToZone concatNel leveling
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case Leveling =>
      Action(size = 40)
    case _ =>
      Action()
  }
}
