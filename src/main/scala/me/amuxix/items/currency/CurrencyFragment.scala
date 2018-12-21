package me.amuxix.items.currency

import me.amuxix.items.{Item, PriceFallback}

/**
  * This represents parts of an [[Orb]] and can't be used on its own but rather needs
  * to be joined with other fragments of the same type before it can be used
  *
  * @param stackSize How many parts does it take to form a full piece of currency
  */
class CurrencyFragment(name: String, val fragmentOf: Currency, val stackSize: Int) extends Item(name, 1, 1, "Currency") with PriceFallback {
  override def fallback: Double = fragmentOf.chaosValuePerSlot.fold(0D)(_ / stackSize)
}

object CurrencyFragment {
  def apply(name: String, fragmentOf: Currency, stackSize: Int): CurrencyFragment = new CurrencyFragment(name, fragmentOf, stackSize)
  def unapply(arg: CurrencyFragment): Option[(String, Currency, Int)] = Some((arg.name, arg.fragmentOf, arg.stackSize))
}
