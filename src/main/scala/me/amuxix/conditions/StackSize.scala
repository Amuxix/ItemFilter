package me.amuxix.conditions

import me.amuxix.Mergeable

object StackSize {
  def apply(start: Int, max: Int): StackSize = new StackSize(start, max, max)

  implicit val mergeable: Mergeable[StackSize] = OperatorWritable.merge(apply)
}
case class StackSize(start: Int, end: Int, override val max: Int) extends OperatorWritable[StackSize](max, "StackSize") {

  override val min: Int = 1
}
