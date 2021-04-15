package me.amuxix.items.currency

import me.amuxix.conditions.Condition
import me.amuxix.items.Currency

case class Prophecy(name: String, dropEnabled: Boolean) extends Currency {
  override val dropLevel: Int = 1
  override val stackSize: Int = 1

  override lazy val condition: Condition = super.condition.copy(base = "Prophecy", prophecy = name)
}
