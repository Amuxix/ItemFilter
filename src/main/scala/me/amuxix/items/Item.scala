package me.amuxix.items

import me.amuxix._
import me.amuxix.conditions.{Condition, ItemClass}
import me.amuxix.providers.Provider

abstract class Item(height: Int, width: Int, `class`: String, _rarity: FilterRarity = Undetermined) extends GenItem(_rarity) {
  lazy val itemClass: ItemClass = ItemClass(`class`)

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

  override protected def condition: Condition = Condition(
    `class` = Some(itemClass),
    base = name,
    height = height,
    width = width
  )
}
