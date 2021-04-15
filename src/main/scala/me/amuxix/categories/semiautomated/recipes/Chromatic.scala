package me.amuxix.categories.semiautomated.recipes

import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

object Chromatic extends Sized {
  override lazy val condition: Condition = Condition(socketGroup = "RGB")
  override def chaosValue(provider: Provider): Option[Double] = provider.currencies.getByName("Chromatic Orb").flatMap(_.chaosValuePerSlot(provider))
}
