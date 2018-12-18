package me.amuxix.items
import me.amuxix.providers.Provider

trait ProviderPrice { this: GenItem =>
  val area: Int
  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  lazy val chaosValuePerSlot: Option[Double] =
    Provider.getChaosEquivalentFor(this).map(_ / area)
}
