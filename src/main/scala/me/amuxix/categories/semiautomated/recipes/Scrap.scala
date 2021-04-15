package me.amuxix.categories.semiautomated.recipes

import me.amuxix.ItemFilter
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

object Scrap extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.settings.armourClasses ++ ItemFilter.settings.shieldClasses, quality = 20)
  override def chaosValue(provider: Provider): Option[Double] = provider.currencies.getByName("Armourer's Scrap").flatMap(_.chaosValuePerSlot(provider))
}
