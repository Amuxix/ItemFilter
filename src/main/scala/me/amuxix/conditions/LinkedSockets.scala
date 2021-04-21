package me.amuxix.conditions

import me.amuxix.Mergeable

/**
  * Created by Amuxix on 03/03/2017.
  */
object LinkedSockets {
  def apply(level: Int): LinkedSockets = new LinkedSockets(level, level)

  implicit val mergeable: Mergeable[LinkedSockets] = OperatorWritable.merge(apply)
}
case class LinkedSockets(start: Int, end: Int) extends OperatorWritable[LinkedSockets](6, "LinkedSockets")
