package me.amuxix.conditions

import me.amuxix.Mergeable

/**
  * Created by Amuxix on 03/03/2017.
  */
object Width {
  def apply(level: Int): Width = new Width(level, level)

  implicit val mergeable: Mergeable[Width] = OperatorWritable.merge(apply)
}
case class Width(start: Int, end: Int) extends OperatorWritable[Width](2, "Width") {

  override val min: Int = 1
}
