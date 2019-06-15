package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
object DropLevel {
  def apply(level: Int): DropLevel = new DropLevel(level)
}
case class DropLevel(start: Int, end: Int) extends OperatorWritable[DropLevel](100, "DropLevel") {
  def this(value: Int) = this(value, value)

  override val min: Int = 1
  override def merge(other: DropLevel): DropLevel =
    DropLevel(start min other.start, end max other.end)
}
