package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.ItemFilter.{config, cutoffs}
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.AlwaysHide
import me.amuxix.FilterRarity.Priced.Leveling

object LevelingCategory extends SemiAutomatedCategory {
  private val itemClasses = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    Bases.allEquipment.map { allEquipment =>
      val closeToZone = allEquipment.flatMap { i =>
        NonEmptyList.of(
          GenericItem(Leveling, i.conditionsOfBestRaresForZoneLevel),
          GenericItem(Leveling, i.conditionsOfGoodRaresForZoneLevel),
          GenericItem(AlwaysHide, i.conditionsOfBestWhitesForZoneLevel),
        )
      }
      val leveling = NonEmptyList.of(
        GenericItem(Leveling, Condition(itemLevel = (1, cutoffs.normalItems), linkedSockets = 3)),
        GenericItem(Leveling, Condition(itemLevel = (1, cutoffs.magicItems), linkedSockets = 4)),
        GenericItem(Leveling, Condition(itemLevel = (1, cutoffs.fourLinkRare), linkedSockets = 4, rarity = GameRare)),
        GenericItem(Leveling, Condition(`class` = "Belt", itemLevel = (1, cutoffs.normalItems))),
        GenericItem(Leveling, Condition(`class` = itemClasses, itemLevel = (1, cutoffs.normalItems), rarity = Normal)),
        GenericItem(Leveling, Condition(`class` = itemClasses, itemLevel = (1, cutoffs.magicItems), rarity = Magic)),
        GenericItem(Leveling, Condition(`class` = config.accessoriesClasses, rarity = GameRare, itemLevel = (1, 60))),
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
