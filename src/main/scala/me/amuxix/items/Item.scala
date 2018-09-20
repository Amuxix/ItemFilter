package me.amuxix.items

import me.amuxix._
import me.amuxix.providers.Provider

abstract class Item(height: Int, width: Int, _rarity: FilterRarity = Undetermined) extends GenItem(_rarity) {
  private val area: Int = height * width
  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  private lazy val chaosValuePerSlot: Double =
    Provider.getChaosEquivalentFor(this).fold[Double](0)(identity) / area

  override lazy val rarity: FilterRarity = {
    if (chaosValuePerSlot >= Mythic.threshold) Mythic
    else if (chaosValuePerSlot >= Epic.threshold) Epic
    else if (chaosValuePerSlot >= Rare.threshold) Rare
    else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
    else if (chaosValuePerSlot >= Common.threshold) Common
    else Undetermined
  }
}
