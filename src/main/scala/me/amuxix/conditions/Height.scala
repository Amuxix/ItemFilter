package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
object Height {
  def apply(level: Int): Height = new Height(level, level)
}

case class Height(start: Int, end: Int) extends OperatorWritable[Height](4, "Height") {

  override val min: Int = 1
  override def merge(other: Height): Height =
    Height(start min other.start, end max other.end)
}
