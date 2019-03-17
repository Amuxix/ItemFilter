package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.database.CurrencyFragments

import scala.concurrent.Future

/**
  * This represents parts of an [[Currency]] and can't be used on its own but rather needs
  * to be joined with other fragments of the same type before it can be used
  *
  * @param stackSize How many parts does it take to form a full piece of currency
  */
case class CurrencyFragment(_name: String, fragmentOf: String, stackSize: Int, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) with StackSize with PriceFallback {
  override def fallback: OptionT[Future, Double] =
    for {
      currency <- CurrencyFragments.getByName(fragmentOf)
      value <- currency.chaosValuePerSlot
    } yield value / stackSize
}
