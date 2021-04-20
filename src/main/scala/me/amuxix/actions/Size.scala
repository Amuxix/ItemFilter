package me.amuxix.actions

import me.amuxix._
import me.amuxix.actions.Size._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Size {
  val default: Size = Size(32)
  private val min: Int = 1
  private val max: Int = 45

  private val reduceAmount = 5
  private val enlargeAmount = 5
}
case class Size(size: Int) extends Writable {
  if (size < Size.min || size > Size.max) throw new InvalidArgument

  def change(amount: Int): Size = Size(((size + amount) max min) min max)
  def smaller: Size = change(-reduceAmount)
  def larger: Size = change(enlargeAmount)

  override def print: String = s"SetFontSize $size"
}
