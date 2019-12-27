package me.amuxix.items
import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

trait ProviderPrice extends Value { this: Item with Area =>
  private def getChaosEquivalentFor(item: Item): OptionT[Future, Double] =
    ItemFilter.provider.getPriceOf(item)
      .orElse(item match {
        case fallback: PriceFallback =>
          println(s"Using fallback price for ${fallback.name}")
          fallback.fallback
        case item if item.dropEnabled == false =>
          println(s"${item.name} drop is disabled")
          OptionT.none
        case other =>
          println(s"No price for ${other.name}")
          OptionT.none
      })

  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  override def chaosValuePerSlot: OptionT[Future, Double] =
    for {
      value <- getChaosEquivalentFor(this)
      area <- area
    } yield value / area
}
