package me.amuxix.items

import me.amuxix.Named

abstract class Item(val height: Int, val width: Int) extends Named {
  /**
    * This is the worth of the currency in chaos.
    */
  def chaosEquivalent: Option[Double] = ???
}
