package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.{Action, White}
import me.amuxix.actions.Color.{black, darkRed, teal}
import me.amuxix.actions.Sound.gems
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object Gems extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenItem]] = Future.successful(
    NonEmptyList.fromListUnsafe(List(
      new CategoryItem(Epic) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem", gemLevel = (20, 21))) },
      new CategoryItem(Rare) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem", gemLevel = (17, 21))) },
      new CategoryItem(Epic) { override lazy val condition: Future[Condition] = Future.successful(Condition(base = "Enlighten", `class` = "Gem")) },
      new CategoryItem(Uncommon) {
        override lazy val condition: Future[Condition] = Future.successful(Condition(
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
        ))
      },
      new CategoryItem(Epic) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem", quality = (20, 30))) },
      new CategoryItem(Rare) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem", quality = (16, 30))) },
      new CategoryItem(Uncommon) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem", quality = (1, 30))) },
      new CategoryItem(Common) { override lazy val condition: Future[Condition] = Future.successful(Condition(base = "Vaal", `class` = "Gem")) },
      new CategoryItem(Leveling) { override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Gem")) },
    ))
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
