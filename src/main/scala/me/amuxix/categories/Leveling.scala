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

  def flaskBlock(flask: Flask): Block = {
    Block(Condition(base = Some(flask.baseType), itemLevel = ("<=", flask.dropLevel + 10)))
  }

  val bigAction = Action(size = 45, borderColor = white)

  val fourLinks = Block(Condition(itemLevel = ("<=", magicCutoff), linkedSockets = 4), bigAction)
  val threeLinks = Block(Condition(itemLevel = ("<=", whiteCutoff), linkedSockets = 3), bigAction)

  val whites = Block(Condition(itemLevel = ("<=", whiteCutoff), rarity = White))
  val magic = Block(Condition(itemLevel = ("<=", magicCutoff), rarity = Magic))

  val bestBases: Seq[Block] = bestEquipment.flatMap(i => Seq(i.rare, i.craftting))
  val bestForZoneLevel: Seq[Block] = allEquipment.map(_.blocksOfBestItemsForZoneLevel)

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => bestBases ++ bestForZoneLevel.map(_.hidden)
    case Normal => bestBases ++ bestForZoneLevel
    case Racing => bestBases ++ bestForZoneLevel ++ Seq(fourLinks, threeLinks, magic, whites)
  }
}
