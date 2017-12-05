package me.amuxix.conditions

import me.amuxix.{Default, InvalidArgument, Operator, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Quality extends Default[Quality] {
  def apply(quality: Int): Quality = new Quality(quality)

  override val default = new Quality(">=", 0)
}
case class Quality(op: Operator, quality: Int) extends BaseCondition with RefEquals {
  if (quality < 0 || quality > 20) throw new InvalidArgument
  def this(quality: Int) = this("=", quality)

  override def print: String = s"Quality ${op.print}$quality"
}
