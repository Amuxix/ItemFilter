package me.amuxix.conditions

import me.amuxix.Mergeable

object Quality {
  def apply(level: Int): Quality = new Quality(level, level)

  implicit val mergeable: Mergeable[Quality] = OperatorWritable.merge(apply)
}
case class Quality(start: Int, end: Int) extends OperatorWritable[Quality](30, "Quality")
