package me.amuxix.categories.automated.recipes
import me.amuxix.ItemFilter
import me.amuxix.conditions.Condition
import me.amuxix.items.currency.BlacksmithsWhetstone

object Whetstone extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.config.weaponClasses, quality = 20)
  override lazy val chaosValue: Option[Double] = BlacksmithsWhetstone.chaosValuePerSlot
}
