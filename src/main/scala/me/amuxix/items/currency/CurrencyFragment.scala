package me.amuxix.items.currency

import me.amuxix.items.{Currency, PriceFallback}
import me.amuxix.providers.Provider

case class CurrencyFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  def fallback(provider: Provider): Option[Double] =
    for {
      currency <- provider.currencies.all.find(_.name == fragmentOf)
      value <- currency.chaosValuePerSlot(provider)
    } yield value / stackSize
}
