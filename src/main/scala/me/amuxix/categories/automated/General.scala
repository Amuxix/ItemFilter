package me.amuxix.categories.automated

import me.amuxix.ItemFilter._
import me.amuxix._
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.actions.{Action, Green, Sound}
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.database.Currencies
import me.amuxix.items.{Base, CategoryItem, GenItem}

import scala.concurrent.Future

object General extends AutomatedCategory {
  private val itemClasses = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses

  override protected lazy val categoryItems: Future[Seq[GenItem]] =
    for {
      jew <- Currencies.getByName("Jeweller's Orb")
      bestItems <- Base.bestItems
      allEquipment <- Base.allEquipment
    } yield {
      Seq(
        new CategoryItem(AlwaysShow) { override def condition: Condition = Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")) },
        new CategoryItem(Mythic) { override def condition: Condition = Condition(base = "Albino Rhoa Feather") },
        new CategoryItem(Mythic) { override def condition: Condition = Condition(`class` = "Fishing Rod") },
        new CategoryItem(Mythic) { override def condition: Condition = Condition(linkedSockets = 6) },
        new CategoryItem(Epic) { override def condition: Condition = Condition(linkedSockets = 5) },
        new GenItem {
          override def chaosValuePerSlot: Option[Double] = jew.chaosValuePerSlot.map(_ * 7)
          override def condition: Condition = Condition(sockets = 6)
        },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (1, cutoffs.normalItems), linkedSockets = 3) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (1, cutoffs.magicItems), linkedSockets = 4) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(itemLevel = (1, cutoffs.fourLinkRare), linkedSockets = 4, rarity = GameRare) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = "Belt", itemLevel = (1, cutoffs.normalItems)) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, cutoffs.normalItems), rarity = Normal) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = itemClasses, itemLevel = (1, cutoffs.magicItems), rarity = Magic) },
        new CategoryItem(Leveling) { override def condition: Condition = Condition(`class` = config.accessoriesClasses, rarity = GameRare, itemLevel = (1, 60)) },
      ) ++ bestItems.flatMap(i => Seq(
        new CategoryItem { override def condition: Condition = i.rare },
        new CategoryItem(AlwaysHide) { override def condition: Condition = i.crafting }
      )) ++ allEquipment.flatMap(i => Seq(
        new CategoryItem(Leveling) { override def condition: Condition = i.conditionsOfBestRaresForZoneLevel },
        new CategoryItem(Leveling) { override def condition: Condition = i.conditionsOfGoodRaresForZoneLevel },
        new CategoryItem(AlwaysHide) { override def condition: Condition = i.conditionsOfBestWhitesForZoneLevel },
      ))
    }




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
