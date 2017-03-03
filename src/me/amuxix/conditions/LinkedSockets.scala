package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
case class LinkedSockets(l: Int) extends BaseCondition{
  if (l < 0 || l > 6) throw InvalidArgumentException

  override def toString: String = super.toString + " " + l
}
