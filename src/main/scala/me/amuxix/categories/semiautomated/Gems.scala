package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, darkRed, teal}
import me.amuxix.actions.Sound.gems
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.FilterRarity.Priced._
import me.amuxix.actions.EffectColor.White

object Gems extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    IO.pure(
      NonEmptyList.of(
        GenericItem(Epic, Condition(`class` = "Gem", gemLevel = (20, 21))),
        GenericItem(Rare, Condition(`class` = "Gem", gemLevel = (17, 21))),
        GenericItem(Epic, Condition(base = "Enlighten", `class` = "Gem")),
        GenericItem(Uncommon, Condition(
          base = Seq(
            "Empower",
            "Item Quantity",
            "Block Chance Reduction",
            "Enhance",
            "Portal",
            "Vaal Breach",
            "Vaal Haste",
            "Vaal Discipline"
          ),
          `class` = "Gem"
        )),
        GenericItem(Epic, Condition(`class` = "Gem", quality = (20, 30))),
        GenericItem(Rare, Condition(`class` = "Gem", quality = (16, 30))),
        GenericItem(Uncommon, Condition(`class` = "Gem", quality = (1, 30))),
        GenericItem(Common, Condition(base = "Vaal", `class` = "Gem")),
        GenericItem(Leveling, Condition(`class` = "Gem")),
      )
    )
  override protected def actionForRarity: FilterRarity => Action = {
    case Leveling =>
      Action(borderColor = teal)
    case Common =>
      Action(size = 40, borderColor = teal)
    case Uncommon =>
      Action(size = 40, sound = gems, borderColor = teal)
    case Rare =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = black, beam = (White, true))
    case _ =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = darkRed, beam = White)
  }
}
