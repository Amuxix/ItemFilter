package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object DropLevel {
  def apply(level: Int): DropLevel = new DropLevel(level)
}
case class DropLevel(op: Operator, level: Int) extends Writable {
  if (level < 0 || level > 100) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  override def print: String = s"DropLevel ${op.print}$level"
}
