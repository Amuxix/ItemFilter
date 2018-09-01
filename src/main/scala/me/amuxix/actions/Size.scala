package me.amuxix.actions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Size {
  val default = 32
  implicit def int2Size(size: Int): Size = Size(size)
  val min: Int = 18
  val max: Int = 45
}
case class Size(size: Int) extends Writable {
  if (size < Size.min || size > Size.max) throw new InvalidArgument
  override def print: String = s"SetFontSize $size"
}
