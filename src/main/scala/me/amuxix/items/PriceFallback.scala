package me.amuxix.items

trait PriceFallback { item: Item =>
  def fallback: Double
}
