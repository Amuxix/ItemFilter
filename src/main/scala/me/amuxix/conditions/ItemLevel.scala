package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel {
  def apply(level: Int): ItemLevel = new ItemLevel(level)
}
case class ItemLevel(op: Either[Operator, Int], level: Int) extends Writable {
  if (level < 0 || level > 100) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  //override def print: String = maxLevel.fold(s"ItemLevel ${op.print}$level")(s"ItemLevel ${op.print}$level")
  override def print: String = op.fold(o => s"ItemLevel ${o.print}$level", min => s"ItemLevel >= $min\n  ItemLevel <= $level")
}
