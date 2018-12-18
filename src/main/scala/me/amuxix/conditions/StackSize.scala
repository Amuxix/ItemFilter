package me.amuxix.conditions

object StackSize {
  def apply(start: Int, max: Int): StackSize = new StackSize(start, max)
}
case class StackSize(start: Int, end: Int, max: Int) extends OperatorWritable[StackSize](max, "StackSize") {
  def this(start: Int, max: Int) = this(start, max, max)

  override val min: Int = 1
  override def merge(other: StackSize): StackSize = StackSize(start min other.start, end max other.end, max max other.max)
}