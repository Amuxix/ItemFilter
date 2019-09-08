package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.ItemFilter.config
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Normal, Rare}
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.{AlwaysHide, AlwaysShow}

object LastCall extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    IO.pure(
      NonEmptyList.of(
        GenericItem(
          AlwaysHide,
          Condition(
            `class` = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses ++ config.flaskClasses,
            rarity = (Normal, Rare)
          )
        ),
        GenericItem(AlwaysShow, Condition()),
      )
    )
  override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide =>
      Action(size = 18, backgroundColor = black.halfTransparent, borderColor = black)
    case _ =>
      Action(textColor = white.darken, backgroundColor = white, borderColor = white)
  }
}
