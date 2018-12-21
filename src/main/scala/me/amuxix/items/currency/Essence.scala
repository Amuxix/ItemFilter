package me.amuxix.items.currency

import me.amuxix.conditions.Condition
import me.amuxix.items.{Item, PriceFallback}

/**
  * Like [[Orb]] this currency can enhance items but they themselves can also be upgraded.
  */
class Essence(name: String, val upgradesTo: Option[Essence]) extends Item(name, 1, 1, "Currency") with PriceFallback {
  override lazy val condition: Condition = Condition(`class` = "Currency", base = name)
  override def fallback: Double = (for {
    essence <- upgradesTo
    value <- essence.chaosValuePerSlot
  } yield value / 3).getOrElse(0)
}

object Essence {
  def apply(name: String, upgradesTo: Option[Essence]): Essence = new Essence(name, upgradesTo)

  def unapply(arg: Essence): Option[(String, Option[Essence])] = Some((arg.name, arg.upgradesTo))
}
