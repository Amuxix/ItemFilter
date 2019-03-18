package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.providers.Provider

import scala.concurrent.Future

trait ProviderPrice { this: GenItem =>
  def area: OptionT[Future, Int]

  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  lazy val chaosValuePerSlot: OptionT[Future, Double] =
    for {
      value <- Provider.getChaosEquivalentFor(this)
      area <- area
    } yield value / area
}
