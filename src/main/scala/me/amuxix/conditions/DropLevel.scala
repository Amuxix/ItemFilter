package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object DropLevel extends Default[DropLevel] {
  def apply(level: Int): DropLevel = new DropLevel(level)

  override val default = DropLevel(">=", 0)
}
case class DropLevel(op: Operator, level: Int) extends BaseCondition with ValueEquals {
  if (level < 0 || level > 100) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  override def print: String = s"DropLevel ${op.print}$level"
}
