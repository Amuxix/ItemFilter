package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
object Quality {
  def apply(quality: Int): Quality = new Quality(quality)
}
case class Quality(op: String, quality: Int) extends HasOperator {
  if (quality < 0 || quality > 20) throw InvalidArgumentException
  def this(quality: Int) = this("", quality)
}
