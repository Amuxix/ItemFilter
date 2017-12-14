package me.amuxix.categories.recipes

import me.amuxix._
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

abstract class Sized extends Category {
  def condition: Condition
  final private val smallArmour = Block(condition.copy(height = 2, width = 2))
  final private val smallWeapon = Block(condition.copy(height = 3, width = 1))
  final private val medium = Block(condition.copy(height = ("<=", 3), width = ("<=", 2)))
  final private val large = Block(condition)

  final override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(smallArmour.hidden, smallWeapon.hidden, medium.hidden, large.hidden)
    case Normal => Seq(smallArmour, smallWeapon, medium.hidden, large.hidden)
    case Racing => Seq(smallArmour, smallWeapon, medium, large.hidden)
  }
}
