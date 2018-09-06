package me.amuxix.items

import me.amuxix.Named

abstract class Item(val size: Size) extends Named {
  /**
    * This is the worth of the currency in chaos.
    */
  def chaosEquivalent: Option[Double] = ???
}
