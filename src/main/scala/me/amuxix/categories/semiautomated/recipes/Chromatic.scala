package me.amuxix.categories.semiautomated.recipes

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

import scala.concurrent.Future

object Chromatic extends Sized {
  override lazy val condition: Condition = Condition(socketGroup = "RGB")
  override lazy val chaosValue: OptionT[Future, Double] = Currencies.getByName("Chromatic Orb").flatMap(_.chaosValuePerSlot)
}
