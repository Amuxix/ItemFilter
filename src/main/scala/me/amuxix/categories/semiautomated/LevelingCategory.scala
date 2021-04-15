package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{AlwaysHide, FilterRarity, Leveling}
import me.amuxix.ItemFilter._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object LevelingCategory extends SemiAutomatedCategory {
  private val itemClasses = settings.accessoriesClasses ++ settings.armourClasses ++ settings.weaponClasses ++ settings.shieldClasses

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = {
    val closeToZone = provider.bases.allEquipment.flatMap { i =>
      NonEmptyList.of(
        new GenericItem {
          override lazy val condition: Condition = i.conditionsOfBestRaresForZoneLevel(provider)
          override def rarity(provider: Provider): FilterRarity = Leveling
        },
        new GenericItem {
          override lazy val condition: Condition = i.conditionsOfGoodRaresForZoneLevel(provider)
          override def rarity(provider: Provider): FilterRarity = Leveling
        },
        new GenericItem {
          override lazy val condition: Condition = i.conditionsOfBestWhitesForZoneLevel(provider)
          override def rarity(provider: Provider): FilterRarity = AlwaysHide
        },
      )
    }
    val leveling = NonEmptyList.of(
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(itemLevel = (1, cutoffs.normalItems), linkedSockets = 3)
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(itemLevel = (1, cutoffs.magicItems), linkedSockets = 4)
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(itemLevel = (1, cutoffs.fourLinkRare), linkedSockets = 4, rarity = GameRare)
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(`class` = "Belt", itemLevel = (1, cutoffs.normalItems))
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, cutoffs.normalItems), rarity = Normal)
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, cutoffs.magicItems), rarity = Magic)
      },
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = Condition(`class` = settings.accessoriesClasses, rarity = GameRare, itemLevel = (1, 60))
      },
    )
    closeToZone concatNel leveling
  }

  override protected def actionForRarity: FilterRarity => Action = {
    case Leveling => Action(size = 40)
    case _        => Action()
  }
}
