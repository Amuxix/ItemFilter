package me.amuxix.categories

import me.amuxix._
import me.amuxix.items.Item.{accessories, bestEquipment}

object BestBases extends Category {
  val bestBases: Seq[Block] = (bestEquipment ++ accessories).flatMap(i => Seq(i.rare, i.craftting))

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case _ => bestBases
  }
}
