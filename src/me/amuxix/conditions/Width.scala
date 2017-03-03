package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Width(op: String, i: Int) extends HasOperator {
  if (i < 1 || i > 2) throw InvalidArgumentException
  def this(i: Int) = this("", i)
  override def toString: String = super.toString + i
}
