package me.amuxix.items

import me.amuxix.providers.Provider

case class Incubator(name: String, dropEnabled: Boolean) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override def area(provider: Provider): Option[Int] = Some(1)
  override val `class`: String = "Incubator"
}
