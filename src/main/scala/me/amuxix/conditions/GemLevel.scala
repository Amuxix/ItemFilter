package me.amuxix.conditions

import me.amuxix.Mergeable

object GemLevel {
  def apply(level: Int): GemLevel = new GemLevel(level, level)

  implicit val mergeable: Mergeable[GemLevel] = OperatorWritable.merge(apply)
}

case class GemLevel(start: Int, end: Int) extends OperatorWritable[GemLevel](21, "GemLevel") {

  override val min: Int = 1
}
