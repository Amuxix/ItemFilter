package me.amuxix.items

import me.amuxix._
import me.amuxix.providers.Provider

trait Value {
  def chaosValuePerSlot(provider: Provider): Option[Double]

  def rarity(provider: Provider): FilterRarity =
    chaosValuePerSlot(provider).fold[FilterRarity](Undetermined) { chaosValuePerSlot =>
      if (chaosValuePerSlot >= Mythic.threshold) Mythic
      else if (chaosValuePerSlot >= Epic.threshold) Epic
      else if (chaosValuePerSlot >= Rare.threshold) Rare
      else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
      else if (chaosValuePerSlot >= Common.threshold) Common
      else Leveling //The price is lower than the lowest threshold.
    }
}
