package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.conditions._
import me.amuxix.items.Flask
import me.amuxix.items.Item._

object Leveling extends Category {
  val whiteCutoff: Int = 15
  val magicCutoff: Int = 30
  val fourLinkRareCutoff: Int = 60

  def flaskBlock(flask: Flask): Block = {
    Block(Condition(base = Some(flask.baseType), itemLevel = ("<=", flask.dropLevel + 10)))
  }

  val bigAction = Action(size = 45, borderColor = white)

  val fourLinks = Block(Condition(itemLevel = ("<=", magicCutoff), linkedSockets = 4), bigAction)
  val threeLinks = Block(Condition(itemLevel = ("<=", whiteCutoff), linkedSockets = 3), bigAction)
  val rareFourLinks = Block(Condition(itemLevel = ("<=", fourLinkRareCutoff), linkedSockets = 4, rarity = Rare), bigAction)
  val belts = Block(Condition(`class` = "Belt", itemLevel = ("<=", whiteCutoff), linkedSockets = 3), bigAction)

  val whites = Block(Condition(itemLevel = ("<=", whiteCutoff), rarity = White))
  val magic = Block(Condition(itemLevel = ("<=", magicCutoff), rarity = Magic))

  val bestForZoneLevel: Seq[Block] = allEquipment.map(_.blocksOfBestItemsForZoneLevel)
  val goodForZoneLevel: Seq[Block] = allEquipment.map(_.blocksOfGoodItemsForZoneLevel)
  val accessor: Block = Block(
      Condition(`class` = Seq("Amulet", "Ring", "Belt"), rarity = Rare)
    )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => (bestForZoneLevel ++ goodForZoneLevel).map(_.hidden) :+ accessor.hidden
    case Normal => bestForZoneLevel ++ goodForZoneLevel.map(_.hidden) :+ accessor
    case Racing => bestForZoneLevel ++ goodForZoneLevel ++ Seq(accessor, rareFourLinks, fourLinks, threeLinks, belts, magic, whites)
  }
}
