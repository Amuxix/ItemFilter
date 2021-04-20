package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
object Width {
  def apply(level: Int): Width = new Width(level, level)
}
case class Width(start: Int, end: Int) extends OperatorWritable[Width](2, "Width") {

  override val min: Int = 1
  override def merge(other: Width): Width =
    Width(start min other.start, end max other.end)
}
