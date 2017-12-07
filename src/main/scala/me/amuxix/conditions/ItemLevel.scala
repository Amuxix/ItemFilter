package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel {
  implicit def tuple22ItemLevel(tuple: (Operator, Int)): ItemLevel = ItemLevel(tuple._1, tuple._2)
  def apply(level: Int): ItemLevel = new ItemLevel(level)
}
case class ItemLevel(op: Operator, level: Int) extends Writable {
  if (level < 0 || level > 100) throw new InvalidArgument
  def this(level: Int) = this("=", level)

  override def print: String = s"ItemLevel ${op.print}$level"
}
