package me.amuxix.categories.recipes

import me.amuxix._
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

object Chromatic extends Category {
  val smallArmor = Block(Condition(socketGroup = "RGB", height = 2, width = 2))
  val smallWeapon = Block(Condition(socketGroup = "RGB", height = 3, width = 1))
  val medium = Block(Condition(socketGroup = "RGB", height = ("<=", 3), width = ("<=", 2)))
  val large = Block(Condition(socketGroup = "RGB"))

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq()
    case Normal => Seq(smallArmor, smallWeapon, medium, large.hidden)
    case Leveling => Seq(smallArmor, smallWeapon, medium.hidden, large.hidden)
  }
}
