package me.amuxix.categories.automated

import me.amuxix._
import me.amuxix.actions.Color.{black, darkRed, teal}
import me.amuxix.actions.Sound.gems
import me.amuxix.actions.{Action, White}
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object Gems extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Future.successful(Seq(
    new CategoryItem(Epic) { override lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = (20, 21)) },
    new CategoryItem(Rare) { override lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = (17, 21)) },
    new CategoryItem(Epic) { override lazy val condition: Condition = Condition(base = "Enlighten", `class` = "Gem") },
    new CategoryItem(Uncommon) {
      override lazy val condition: Condition = Condition(
      base = Seq(
        "Empower",
        "Item Quantity",
        "Block Chance Reduction",
        "Enhance",
        "Added Chaos Damage",
        "Detonate Mines",
        "Portal",
        "Vaal Breach",
        "Vaal Haste",
        "Vaal Discipline"
      ),
      `class` = "Gem"
    )
    },
    new CategoryItem(Epic) { override lazy val condition: Condition = Condition(`class` = "Gem", quality = (20, 30)) },
    new CategoryItem(Rare) { override lazy val condition: Condition = Condition(`class` = "Gem", quality = (16, 30)) },
    new CategoryItem(Uncommon) { override lazy val condition: Condition = Condition(`class` = "Gem", quality = (1, 30)) },
    new CategoryItem(Common) { override lazy val condition: Condition = Condition(base = "Vaal", `class` = "Gem") },
    new CategoryItem(Leveling) { override lazy val condition: Condition = Condition(`class` = "Gem") },
  ))
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
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
