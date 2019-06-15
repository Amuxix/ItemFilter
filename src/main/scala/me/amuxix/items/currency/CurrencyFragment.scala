package me.amuxix.items.currency

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.ItemFilter.ec
import me.amuxix.database.Currencies
import me.amuxix.items.{Currency, PriceFallback}

import scala.concurrent.Future

case class CurrencyFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  override def fallback: OptionT[Future, Double] =
    for {
      currency <- OptionT(Currencies.all.map(_.find(_.name == fragmentOf)))
      value <- currency.chaosValuePerSlot
    } yield value / stackSize
}
