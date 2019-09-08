package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.FilterRarity.Priced.Leveling
import me.amuxix.FilterRarity.Undetermined
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{darkRed, goodYellow, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.database.Bases
import me.amuxix.items.GenericItem

object Rares extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    for {
      bestItems <- Bases.bestItems
      allEquipment <- Bases.allEquipment
    } yield {
      val best = bestItems.flatMap { item =>
        NonEmptyList.of(
          GenericItem(Undetermined, item.rare.map(_.copy(fracturedItem = true))),
          GenericItem(Undetermined, item.rare.map(_.copy(shaperItem = true))),
          GenericItem(Undetermined, item.rare.map(_.copy(elderItem = true))),
        )
      }
      val all = allEquipment.flatMap { item =>
        NonEmptyList.of(
          GenericItem(Leveling, item.conditionsOfBestRaresForZoneLevel.map(_.copy(fracturedItem = true))),
          GenericItem(Leveling, item.conditionsOfGoodRaresForZoneLevel.map(_.copy(fracturedItem = true))),
          GenericItem(Leveling, item.conditionsOfBestRaresForZoneLevel.map(_.copy(shaperItem = true))),
          GenericItem(Leveling, item.conditionsOfGoodRaresForZoneLevel.map(_.copy(shaperItem = true))),
          GenericItem(Leveling, item.conditionsOfBestRaresForZoneLevel.map(_.copy(elderItem = true))),
          GenericItem(Leveling, item.conditionsOfGoodRaresForZoneLevel.map(_.copy(elderItem = true))),
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
