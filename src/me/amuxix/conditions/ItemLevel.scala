package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
object ItemLevel {
  def apply(level: Int): ItemLevel = new ItemLevel(level)
}
case class ItemLevel(op: String, level: Int) extends HasOperator{
  if (level < 0 || level > 100) throw InvalidArgumentException
  def this(level: Int) = this("", level)

  override def toString: String = super.toString + level
}
