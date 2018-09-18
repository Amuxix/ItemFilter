package me.amuxix.categories2
import me.amuxix.actions.Action
import me.amuxix.actions.Color.white
import me.amuxix.conditions.{Condition, Magic, Rare, White}
import me.amuxix.items.GenItem
import me.amuxix.{FilterRarity, Leveling => LevelingRarity}

object Leveling extends AutomatedCategory {
  val whiteCutoff: Int = 15
  val magicCutoff: Int = 30
  val fourLinkRareCutoff: Int = 60

  override protected val categoryItems: Seq[GenItem] = me.amuxix.items.bases.LifeFlask.flasks ++ Seq(
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(itemLevel = ("<=", magicCutoff), linkedSockets = 4) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(itemLevel = ("<=", whiteCutoff), linkedSockets = 3) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(itemLevel = ("<=", fourLinkRareCutoff), linkedSockets = 4, rarity = Rare) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(`class` = "Belt", itemLevel = ("<=", whiteCutoff)) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(itemLevel = ("<=", whiteCutoff), rarity = White) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(itemLevel = ("<=", magicCutoff), rarity = Magic) },
    new GenItem(LevelingRarity) { override protected def condition: Condition = Condition(`class` = Seq("Amulet", "Ring", "Belt"), rarity = Rare, itemLevel = ("<", 60)) },
  )
  /*
  TODO: Find solution to fit best bases
  val bestRaresForZoneLevel: Seq[Block] = allEquipment.map(_.conditionsOfBestRaresForZoneLevel())
  val goodRaresForZoneLevel: Seq[Block] = allEquipment.map(_.conditionsOfGoodRaresForZoneLevel())
  val bestWhitesForZoneLevel: Seq[Block] = allEquipment.map(_.conditionsOfBestWhitesForZoneLevel())
   */

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case LevelingRarity => Action(size = 45, borderColor = white)
    case _ => Action()
  }
}
