package me.amuxix.providers.prices

import cats.effect.IO
import me.amuxix.items.Item

private[providers] case class PriceProvider(
  itemPrices: Map[String, Double]
) {
  def getPriceOf(item: Item): Option[Double] = itemPrices.get(item.name.toLowerCase)
}

object PriceProvider {
  def fromProvider(provider: Provider): IO[PriceProvider] = provider.itemPrices.map(PriceProvider(_))
}
