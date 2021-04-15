package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{AlwaysHide, AlwaysShow, FilterRarity}
import me.amuxix.ItemFilter._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Normal, Rare}
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object LastCall extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.of(
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = AlwaysHide

      override lazy val condition: Condition = Condition(
        `class` = settings.accessoriesClasses ++ settings.armourClasses ++ settings.weaponClasses ++ settings.shieldClasses ++ settings.flaskClasses,
        rarity = (Normal, Rare),
      )
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = AlwaysShow
      override lazy val condition: Condition = Condition()
    }
  )

  override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide => Action(size = 18, backgroundColor = black.halfTransparent, borderColor = black)
    case _          => Action(textColor = white.darken, backgroundColor = white, borderColor = white)
  }
}
