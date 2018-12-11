package me.amuxix.categories.automated.recipes
import me.amuxix.ItemFilter
import me.amuxix.conditions.Condition
import me.amuxix.items.currency.ArmourersScrap

object Scrap extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.armourClasses ++ ItemFilter.shieldClasses, quality = 20)
  override lazy val chaosValue: Option[Double] = ArmourersScrap.chaosValuePerSlot
}
