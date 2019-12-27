package me.amuxix.items.currency

import me.amuxix.items.Currency

case class Catalyst(name: String, dropEnabled: Boolean) extends Currency {
  override val stackSize: Int = 10
  override val dropLevel: Int = 1
}
