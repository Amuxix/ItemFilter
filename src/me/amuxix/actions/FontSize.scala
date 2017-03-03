package me.amuxix.actions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
case class FontSize(size: Int) extends BaseAction {
  if(size < 18 || size > 45) throw InvalidArgumentException
  override def toString: String = s"SetFontSize $size"
}
