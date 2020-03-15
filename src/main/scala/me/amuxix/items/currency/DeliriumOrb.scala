package me.amuxix.items.currency

import me.amuxix.items.Currency

case class DeliriumOrb(name: String, stackSize: Int, dropEnabled: Boolean) extends Currency {
  override val dropLevel: Int = 1
}
