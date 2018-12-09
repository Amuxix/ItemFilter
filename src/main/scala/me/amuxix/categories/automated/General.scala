package me.amuxix.categories.automated

import me.amuxix._
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.actions.{Action, Sound}
import me.amuxix.conditions.{Condition, Magic, Rare, White}
import me.amuxix.items.GenItem
import me.amuxix.items.bases.Base.{allEquipment, bestItems}
import me.amuxix.items.currency.JewellersOrb

object General extends AutomatedCategory {
  val whiteCutoff: Int = 15
  val magicCutoff: Int = 30
  val fourLinkRareCutoff: Int = 60
  override protected lazy val categoryItems: Seq[GenItem] = Seq(
    new GenItem(AlwaysShow) { override protected def condition: Condition = Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")) },
    new GenItem(AlwaysShow) { override protected def condition: Condition = Condition(base = "Divine Vessel") },
    new GenItem(Mythic) { override protected def condition: Condition = Condition(base = Seq("Albino Rhoa Feather", "Timeworn Reliquary Key")) },
    new GenItem(Mythic) { override protected def condition: Condition = Condition(`class` = "Fishing Rod") },
    new GenItem(Mythic) { override protected def condition: Condition = Condition(linkedSockets = 6) },
    new GenItem(Epic) { override protected def condition: Condition = Condition(linkedSockets = 5) },
    new GenItem(JewellersOrb.rarity) { override protected def condition: Condition = Condition(sockets = 6) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(itemLevel = ("<=", magicCutoff), linkedSockets = 4) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(itemLevel = ("<=", whiteCutoff), linkedSockets = 3) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(itemLevel = ("<=", fourLinkRareCutoff), linkedSockets = 4, rarity = Rare) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(`class` = "Belt", itemLevel = ("<=", whiteCutoff)) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(itemLevel = ("<=", whiteCutoff), rarity = White) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(itemLevel = ("<=", magicCutoff), rarity = Magic) },
    new GenItem(Leveling) { override protected def condition: Condition = Condition(`class` = Seq("Amulet", "Ring", "Belt"), rarity = Rare, itemLevel = ("<", 60)) },
  ) ++ bestItems.flatMap(i => Seq(
      new GenItem(Uncommon) { override protected def condition: Condition = i.rare },
      new GenItem(AlwaysHide) { override protected def condition: Condition = i.crafting }
    )) ++ allEquipment.flatMap(i => Seq(
    new GenItem(Leveling) { override protected def condition: Condition = i.conditionsOfBestRaresForZoneLevel },
    new GenItem(Leveling) { override protected def condition: Condition = i.conditionsOfGoodRaresForZoneLevel },
    new GenItem(Leveling) { override protected def condition: Condition = i.conditionsOfBestWhitesForZoneLevel },
  ))

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysShow =>
      Action(size = 45)
    case Mythic =>
      Action(size = 45, sound = Sound.myths, borderColor = red, backgroundColor = white, textColor = red)
    case Uncommon =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case AlwaysHide =>
      Action()
    case Leveling =>
      Action(size = 45, borderColor = white)
    case _ =>
      Action(size = 45, sound = Sound.epic, borderColor = red)
  }
}
