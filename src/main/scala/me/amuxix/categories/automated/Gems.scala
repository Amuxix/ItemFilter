package me.amuxix.categories.automated

import me.amuxix._
import me.amuxix.actions.Color.{black, darkRed, teal}
import me.amuxix.actions.Sound.gems
import me.amuxix.actions.{Action, Color, White}
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem

object Gems extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem(Mythic) { override protected lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = ("=", 20)) },
    new GenItem(Epic) { override protected lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = (">=", 17)) },
    new GenItem(Mythic) { override protected lazy val condition: Condition = Condition(base = "Enlighten", `class` = "Gem") },
    new GenItem(Rare) { override protected lazy val condition: Condition = Condition(
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
    ) },
    new GenItem(Epic) { override protected lazy val condition: Condition = Condition(`class` = "Gem", quality = ("=", 20)) },
    new GenItem(Rare) { override protected lazy val condition: Condition = Condition(`class` = "Gem", quality = (">=", 16)) },
    new GenItem(Uncommon) { override protected lazy val condition: Condition = Condition(`class` = "Gem", quality = (">=", 1)) },
    new GenItem(Common) { override protected lazy val condition: Condition = Condition(base = "Vaal", `class` = "Gem") },
    new GenItem(Leveling) { override protected lazy val condition: Condition = Condition(`class` = "Gem") },
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case Mythic =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = black, beam = White)
    case Epic =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = black, beam = (White, true))
    case Rare =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = darkRed)
    case Uncommon =>
      Action(size = 40, sound = gems, borderColor = teal, backgroundColor = darkRed)
    case Common =>
      Action(size = 40, borderColor = Color.teal, backgroundColor = Color.black)
    case _ =>
      Action(borderColor = Color.teal, backgroundColor = Color.black)
  }
}
