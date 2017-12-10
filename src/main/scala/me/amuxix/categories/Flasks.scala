package me.amuxix.categories

import me.amuxix._
import me.amuxix.conditions.{Condition, Magic, White}
import me.amuxix.items.Item.flasks

object Flasks extends Category {
  val glassblowers = Block(Condition(`class`= "Flask", quality = 20))
  val mapMagic = Block(Condition(`class`= "Flask", itemLevel = (">=", 68), rarity = Magic, quality = (">=", 12)))
  val mapWhite = Block(Condition(`class`= "Flask", itemLevel = (">=", 68), rarity = White))
  val preMapUtility = Block(Condition(`class`= "Utility Flask", itemLevel = ("<", 68)))
  val resourceFlasks: Seq[Block] = flasks.flatten.map(_.blocksOfBestItemsForZoneLevel)

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(glassblowers, mapMagic.hidden, mapWhite.hidden, preMapUtility) ++ resourceFlasks.map(_.hidden)
    case _ => Seq(glassblowers, mapMagic, mapWhite, preMapUtility) ++ resourceFlasks
  }
}
