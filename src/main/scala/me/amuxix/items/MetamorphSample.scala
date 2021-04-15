package me.amuxix.items

import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.providers.Provider

case class MetamorphSample(name: String, dropEnabled: Boolean) extends Item with Area {
  override val dropLevel: Int = 1
  override def area(provider: Provider): Option[Int] = Some(1)
  override val `class`: String = "Metamorph Sample"

  override def rarity(provider: Provider): FilterRarity = AlwaysShow
}
