package me.amuxix.actions

import cats.Show
import me.amuxix._
import me.amuxix.actions.Size._

/**
  * Created by Amuxix on 03/03/2017.
  */
object Size {
  private val min: Int = 1
  private val max: Int = 45

  private val reduceAmount = 5
  private val enlargeAmount = 5

  implicit val show: Show[Size] = size => s"SetFontSize ${size.size}"

  lazy val default: Size = Size(32)
}
case class Size(size: Int) {
  if (size < Size.min || size > Size.max) throw new InvalidArgument

  def change(amount: Int): Size = Size(((size + amount) max min) min max)
  def smaller: Size = change(-reduceAmount)
  def larger: Size = change(enlargeAmount)
}
