package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.{Action, Color}
import me.amuxix.conditions._
import me.amuxix.items.bases.Base.flasks

object Flasks extends Category {
  val whiteBorder = Action(borderColor = Color.white)
  val glassblowers = Block(Condition(`class` = "Flask", quality = 20), whiteBorder)
  val mapMagic = Block(Condition(`class` = "Flask", itemLevel = (">=", 68), rarity = Magic, quality = (">=", 12)), whiteBorder)
  val mapWhite = Block(Condition(`class` = "Flask", itemLevel = (">=", 68), rarity = White, quality = (">", 0)), whiteBorder)
  val preMap = Block(Condition(`class` = "Flask", itemLevel = ("<", 68), quality = (">", 0)), whiteBorder)
  val preMapUtility = Block(Condition(`class` = "Utility Flask", itemLevel = ("<", 68)))
  val resourceFlasks: Seq[Block] = flasks.flatten.sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse).map(_.blocksOfBestRaresForZoneLevel())

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(glassblowers, mapMagic.hidden, mapWhite.hidden, preMapUtility.hidden, preMap.hidden) ++ resourceFlasks.map(_.hidden)
    case Normal  => Seq(glassblowers, mapMagic, mapWhite, preMapUtility, preMap)
    case Racing  => Seq(glassblowers, mapMagic, mapWhite, preMapUtility, preMap) ++ resourceFlasks
  }
}
