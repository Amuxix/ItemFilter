package me.amuxix.conditions

import me.amuxix.Mergeable

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel {
  def apply(level: Int): ItemLevel = new ItemLevel(level, level)

  implicit val mergeable: Mergeable[ItemLevel] = OperatorWritable.merge(apply)
}
case class ItemLevel(start: Int, end: Int) extends OperatorWritable[ItemLevel](100, "ItemLevel") {
  require(start > 0)

  override val min: Int = 1
}
