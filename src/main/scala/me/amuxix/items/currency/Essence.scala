package me.amuxix.items.currency

import me.amuxix.items.{Currency, PriceFallback}
import me.amuxix.providers.Provider

case class Essence(name: String, upgradesTo: Option[String], dropEnabled: Boolean) extends Currency with PriceFallback {
  override val stackSize: Int = 1
  override val dropLevel: Int = 1

  override def fallback(provider: Provider): Option[Double] =
    for {
      upgrade <- upgradesTo
      essence <- provider.essences.all.find(_.name == upgrade)
      value <- essence.chaosValuePerSlot(provider)
    } yield value / 3
}
