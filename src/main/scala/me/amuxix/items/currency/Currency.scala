package me.amuxix.items.currency

import me.amuxix.Named

/**
  * This is the parent of all currency marker traits.
  */
trait Currency extends Named {
  /**
    * This is the worth of the currency in chaos.
    */
  def chaosEquivalent: Double = ???
}
