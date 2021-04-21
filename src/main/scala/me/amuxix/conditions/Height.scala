package me.amuxix.conditions

import me.amuxix.Mergeable

/**
  * Created by Amuxix on 03/03/2017.
  */
object Height {
  def apply(level: Int): Height = new Height(level, level)

  implicit val mergeable: Mergeable[Height] = OperatorWritable.merge(apply)
}

case class Height(start: Int, end: Int) extends OperatorWritable[Height](4, "Height") {

  override val min: Int = 1
}
