package me.amuxix.actions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
object Color {
  def apply(r: Int, g: Int, b: Int): Color = new Color(r, g, b)
}
class Color(r: Int, g: Int, b: Int, a: Int) {
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)
  Seq(r, g, b, a).foreach{ p =>
    if (p < 0 || p > 255) {
      throw InvalidArgumentException
    }
  }
  override def toString: String = s"$r $g $b $a"
}
