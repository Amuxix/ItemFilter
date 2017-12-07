package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Quality {
  implicit def tuple22Quality(tuple: (Operator, Int)): Quality = Quality(tuple._1, tuple._2)
  def apply(quality: Int): Quality = new Quality(quality)
}
case class Quality(op: Operator, quality: Int) extends Writable {
  if (quality < 0 || quality > 20) throw new InvalidArgument
  def this(quality: Int) = this("=", quality)

  override def print: String = s"Quality ${op.print}$quality"
}
