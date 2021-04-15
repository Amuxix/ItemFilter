package me.amuxix.items

import me.amuxix.providers.Provider

trait PriceFallback { item: ProviderPrice =>
  def fallback(provider: Provider): Option[Double]
}
