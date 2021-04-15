package me.amuxix.items

import me.amuxix.providers.Provider

trait ProviderPrice extends Value { this: Item with Area =>

  private def getChaosEquivalentFor(provider: Provider, item: Item): Option[Double] = provider.getPriceOf(item).orElse(item match {
    case fallback: PriceFallback =>
      println(s"Using fallback price for ${fallback.name}")
      fallback.fallback(provider)
    case item if item.dropEnabled == false =>
      println(s"${item.name} drop is disabled")
      None
    case other =>
      println(s"No price for ${other.name}")
      None
  })

  /** This is the worth of the currency in chaos per slot the item has.
    */
  override def chaosValuePerSlot(provider: Provider): Option[Double] = for {
    value <- getChaosEquivalentFor(provider, this)
    area <- area(provider)
  } yield value / area
}
