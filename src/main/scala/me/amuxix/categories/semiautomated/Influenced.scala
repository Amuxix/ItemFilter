package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{darkRed, goodYellow}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Influences}
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Influenced extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = provider.bases.allEquipment.flatMap { i =>
    val fractured: GenericItem = new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Undetermined
      override lazy val condition: Condition = i.rare.copy(fracturedItem = true)
    }

    val withInfluence = NonEmptyList.fromListUnsafe(Influences.values.toList).map { influence =>
      new GenericItem {
        override def rarity(provider: Provider): FilterRarity = Undetermined
        override lazy val condition: Condition = i.rare.copy(influence = influence)
      }
    }
    withInfluence :+ fractured
  }

  override protected def actionForRarity: FilterRarity => Action = { case Undetermined => Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow) }
}
