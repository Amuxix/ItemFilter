package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.{Action, White}
import me.amuxix.actions.Color.{black, darkRed, teal}
import me.amuxix.actions.Sound.gems
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Gems extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.of(
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Epic
      override lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = (20, 21))
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Rare
      override lazy val condition: Condition = Condition(`class` = "Gem", gemLevel = (17, 21))
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Epic
      override lazy val condition: Condition = Condition(base = "Enlighten", `class` = "Gem")
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Uncommon

      override lazy val condition: Condition = Condition(base = Seq("Empower", "Item Quantity", "Block Chance Reduction", "Enhance", "Portal", "Vaal Breach", "Vaal Haste", "Vaal Discipline", "Awakened"), `class` = "Gem")
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Epic
      override lazy val condition: Condition = Condition(`class` = "Gem", quality = (20, 30))
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Rare
      override lazy val condition: Condition = Condition(`class` = "Gem", quality = (16, 30))
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Uncommon
      override lazy val condition: Condition = Condition(`class` = "Gem", quality = (1, 30))
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Common
      override lazy val condition: Condition = Condition(base = "Vaal", `class` = "Gem")
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = Leveling
      override lazy val condition: Condition = Condition(`class` = "Gem")
    },
    new GenericItem {
      override def rarity(provider: Provider): FilterRarity = AlwaysShow
      override lazy val condition: Condition = Condition(`class` = "Gem", alternateQuality = true)
    },
  )

  override protected def actionForRarity: FilterRarity => Action = {
    case Leveling => Action(borderColor = teal)
    case Common   => Action(size = 40, borderColor = teal)
    case Uncommon => Action(size = 40, sound = gems, borderColor = teal)
    case Rare     => Action(size = 40, sound = gems, borderColor = teal, backgroundColor = black, beam = (White, true))
    case _        => Action(size = 40, sound = gems, borderColor = teal, backgroundColor = darkRed, beam = White)
  }
}
