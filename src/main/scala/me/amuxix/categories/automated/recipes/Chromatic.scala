package me.amuxix.categories.automated.recipes
import me.amuxix.conditions.Condition
import me.amuxix.items.currency.ChromaticOrb

object Chromatic extends Sized {
  override lazy val condition: Condition = Condition(socketGroup = "RGB")
  override lazy val chaosValue: Option[Double] = ChromaticOrb.chaosValuePerSlot
}
