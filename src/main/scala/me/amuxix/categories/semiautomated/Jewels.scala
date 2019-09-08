package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Rare => GameRare}
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.Priced.{Leveling, Uncommon}

object Jewels extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    IO.pure(
      NonEmptyList.of(
        GenericItem(Uncommon, Condition(`class` = "Jewel", rarity = GameRare)),
        GenericItem(Leveling, Condition(`class` = "Jewel")),
      )
    )
  override protected def actionForRarity = {
    case Uncommon =>
      Action(size = 40)
    case _ =>
      Action(size = 35)
  }
}
