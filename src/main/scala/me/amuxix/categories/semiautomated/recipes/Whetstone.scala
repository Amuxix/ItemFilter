package me.amuxix.categories.semiautomated.recipes

import me.amuxix.ItemFilter
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

object Whetstone extends Sized {
  override lazy val condition: Condition =
    Condition(`class` = ItemFilter.settings.weaponClasses, quality = 20)
  override def chaosValue(provider: Provider): Option[Double] = provider.currencies.getByName("Blacksmith's Whetstone").flatMap(_.chaosValuePerSlot(provider))
}
