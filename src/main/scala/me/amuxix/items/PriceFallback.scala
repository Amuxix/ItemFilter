package me.amuxix.items
import cats.data.OptionT

import scala.concurrent.Future

trait PriceFallback { item: ProviderPrice =>
  def fallback: OptionT[Future, Double]
}
