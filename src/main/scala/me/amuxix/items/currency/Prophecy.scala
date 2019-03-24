package me.amuxix.items.currency

import me.amuxix.conditions.Condition
import me.amuxix.ItemFilter.ec
import me.amuxix.items.Currency

import scala.concurrent.Future

case class Prophecy(
  name: String,
  dropEnabled: Boolean,
) extends Currency {
  override val dropLevel: Int = 1
  override val stackSize: Int = 1

  override lazy val condition: Future[Condition] = super.condition.map(_.copy(
    base = "Prophecy",
    prophecy = name,
  ))
}
