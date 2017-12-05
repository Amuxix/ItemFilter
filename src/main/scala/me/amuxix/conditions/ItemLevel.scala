package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel extends Default[ItemLevel] {
  def apply(level: Int): ItemLevel = new ItemLevel(level)

  override val default = ItemLevel(">=", 0)
}
case class ItemLevel(op: Operator, level: Int) extends BaseCondition with ValueEquals {
  if (level < 0 || level > 100) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  override def print: String = s"ItemLevel ${op.print}$level"
}
