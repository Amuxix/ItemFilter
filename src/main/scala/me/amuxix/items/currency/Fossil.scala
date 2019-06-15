package me.amuxix.items.currency
import me.amuxix.items.Currency

case class Fossil(name: String, dropEnabled: Boolean) extends Currency {
  override val stackSize: Int = 1
  override val dropLevel: Int = 1
}
