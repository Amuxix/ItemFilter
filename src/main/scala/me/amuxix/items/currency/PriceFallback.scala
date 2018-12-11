package me.amuxix.items.currency
import me.amuxix.items.Item

trait PriceFallback { item: Item =>
  def fallback: Double
}
