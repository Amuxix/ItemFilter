package me.amuxix.items.currency

import me.amuxix.items.Item

class Currency(name: String, val stackSize: Int, val currencyType: String) extends Item(name, 1, 1, "Currency")

object Currency {
  def apply(name: String, stackSize: Int, currencyType: String): Currency = new Currency(name, stackSize, currencyType)

  def unapply(arg: Currency): Option[(String, Int, String)] = Some((arg.name, arg.stackSize, arg.currencyType))
}