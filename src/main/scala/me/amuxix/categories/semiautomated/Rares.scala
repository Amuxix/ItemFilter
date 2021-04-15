package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.syntax.flatMap._
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{darkRed, goodYellow, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{Corruptible, CraftableBase, GenericItem}
import me.amuxix.providers.Provider

object Rares extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] =
    NonEmptyList.of(best(provider.bases.bestItems), bestForZone(provider, provider.bases.allEquipment), goodForZone(provider, provider.bases.allEquipment)).flatten

  private def best(bestItems: NonEmptyList[CraftableBase with Corruptible]): NonEmptyList[GenericItem] =
    bestItems.flatMap { i =>
      val topRare: GenericItem = new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Undetermined
        override lazy val condition: Condition = i.topRare
      }
      val rare: GenericItem = new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Common
        override lazy val condition: Condition = i.rare
      }
      NonEmptyList.of(rare, topRare)
    }

  def bestForZone(provider: Provider, allEquipment: NonEmptyList[CraftableBase with Corruptible]): NonEmptyList[GenericItem] =
    allEquipment.map { i =>
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = i.conditionsOfBestRaresForZoneLevel(provider)
      }
    }

  private def goodForZone(provider: Provider, allEquipment: NonEmptyList[CraftableBase with Corruptible]): NonEmptyList[GenericItem] =
    allEquipment.map { i =>
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Leveling
        override lazy val condition: Condition = i.conditionsOfGoodRaresForZoneLevel(provider)
      }
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case Undetermined => Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Common       => Action()
    case Leveling     => Action(size = 40, borderColor = white)
  }
}
