package me.amuxix.conditions

object StackSize {
  def apply(start: Int, max: Int): StackSize = new StackSize(start, max, max)
}
case class StackSize(start: Int, end: Int, override val max: Int) extends OperatorWritable[StackSize](max, "StackSize") {

  override val min: Int = 1
  override def merge(other: StackSize): StackSize =
    StackSize(start min other.start, end max other.end, max max other.max)
}
