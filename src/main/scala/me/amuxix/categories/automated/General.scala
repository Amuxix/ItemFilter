package me.amuxix.categories.automated

import me.amuxix.ItemFilter._
import me.amuxix._
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.actions.{Action, Green, Sound}
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.items.bases.Base.{allEquipment, bestItems}
import me.amuxix.items.currency.JewellersOrb
import me.amuxix.items.{CategoryItem, GenItem}

object General extends AutomatedCategory {
  private val itemClasses = accessoriesClasses ++ armourClasses ++ weaponClasses ++ shieldClasses

  override protected lazy val categoryItems: Seq[GenItem] = Seq(
    new CategoryItem(AlwaysShow) { override def condition: Condition = Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")) },
    new CategoryItem(AlwaysShow) { override def condition: Condition = Condition(base = "Divine Vessel") },
    new CategoryItem(Mythic) { override def condition: Condition = Condition(base = Seq("Albino Rhoa Feather", "Timeworn Reliquary Key")) },
    new CategoryItem(Mythic) { override def condition: Condition = Condition(`class` = "Fishing Rod") },
    new CategoryItem(Mythic) { override def condition: Condition = Condition(linkedSockets = 6) },
    new CategoryItem(Epic) { override def condition: Condition = Condition(linkedSockets = 5) },
    new GenItem {
      override def chaosValuePerSlot: Option[Double] = JewellersOrb.chaosValuePerSlot.map(_ * 7)
      override def condition: Condition = Condition(sockets = 6)
    },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (0, magicCutoff), linkedSockets = 4) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (0, whiteCutoff), linkedSockets = 3) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (0, fourLinkRareCutoff), linkedSockets = 4, rarity = GameRare) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = "Belt", itemLevel = (0, whiteCutoff)) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, whiteCutoff), rarity = Normal) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, magicCutoff), rarity = Magic) },
    new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = Seq("Amulet", "Ring", "Belt"), rarity = GameRare, itemLevel = (0, 60)) },
  ) ++ bestItems.flatMap(i => Seq(
    new CategoryItem { override def condition: Condition = i.rare },
    new CategoryItem(AlwaysHide) { override def condition: Condition = i.crafting }
  )) ++ allEquipment.flatMap(i => Seq(
    new CategoryItem(Leveling) { override def condition: Condition = i.conditionsOfBestRaresForZoneLevel },
    new CategoryItem(Leveling) { override def condition: Condition = i.conditionsOfGoodRaresForZoneLevel },
    new CategoryItem(Leveling) { override def condition: Condition = i.conditionsOfBestWhitesForZoneLevel },
  ))


  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysHide =>
      Action()
    case AlwaysShow =>
      Action(size = 45, beam = Green)
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Leveling =>
      Action(size = 45, borderColor = white)
    case Mythic =>
      Action(size = 45, sound = Sound.myths, borderColor = red, backgroundColor = white, textColor = red)
    case _ => //5Linkeds and 6 sockets
      Action(size = 45, sound = Sound.epic, borderColor = red)
  }
}
