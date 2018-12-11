package me.amuxix.conditions


/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel {
  def apply(level: Int): ItemLevel = new ItemLevel(level)
}
case class ItemLevel(start: Int, end: Int) extends OperatorWritable[ItemLevel](100, "ItemLevel") {
  def this(value: Int) = this(value, value)

  override def merge(other: ItemLevel): ItemLevel = ItemLevel(start min other.start, end max other.end)
}