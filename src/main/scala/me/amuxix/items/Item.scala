package me.amuxix.items

import me.amuxix.conditions.{Condition, ItemClass}
import me.amuxix.providers.Provider

abstract class Item(height: Int, width: Int, `class`: String) extends GenItem {
  lazy val itemClass: ItemClass = ItemClass(`class`)

  private val area: Int = height * width
  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  override lazy val chaosValuePerSlot: Option[Double] =
    Provider.getChaosEquivalentFor(this).map(_ / area)

  override protected def condition: Condition = Condition(
    `class` = Some(itemClass),
    base = name,
    height = height,
    width = width
  )
}
