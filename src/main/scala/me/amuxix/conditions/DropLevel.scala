package me.amuxix.conditions

import me.amuxix.Mergeable

/**
  * Created by Amuxix on 03/03/2017.
  */
object DropLevel {
  def apply(level: Int): DropLevel = new DropLevel(level, level)

  implicit val mergeable: Mergeable[DropLevel] = OperatorWritable.merge(apply)
}

case class DropLevel(start: Int, end: Int) extends OperatorWritable[DropLevel](100, "DropLevel") {

  override val min: Int = 1
}
