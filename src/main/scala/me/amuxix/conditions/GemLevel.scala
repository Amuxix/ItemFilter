package me.amuxix.conditions

import me.amuxix.{InvalidArgument, Operator, Writable}

object GemLevel {
  implicit def tuple22GemLevel(tuple: (Operator, Int)): GemLevel = GemLevel(tuple._1, tuple._2)
  def apply(level: Int): GemLevel = new GemLevel(level)
}
case class GemLevel(op: Operator, level: Int) extends Writable {
  if (level < 0 || level > 20) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  override def print: String = s"GemLevel ${op.print}$level"
}