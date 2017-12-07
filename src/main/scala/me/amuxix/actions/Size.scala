package me.amuxix.actions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Size {
  val default = 32
  implicit def int2Size(size: Int): Size = Size(size)
}
case class Size(size: Int) extends Writable {
  if(size < 18 || size > 45) throw new InvalidArgument
  override def print: String = s"SetFontSize $size"
}