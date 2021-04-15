package me.amuxix.items

import me.amuxix.{FilterRarity, Undetermined}
import me.amuxix.providers.Provider

abstract class Base extends Item with Dimensions with Uniques {
  override def rarity(provider: Provider): FilterRarity = Undetermined
  override lazy val `class`: String = className
}
