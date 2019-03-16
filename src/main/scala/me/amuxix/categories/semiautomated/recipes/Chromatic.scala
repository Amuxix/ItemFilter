package me.amuxix.categories.semiautomated.recipes
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

import scala.concurrent.Future

object Chromatic extends Sized {
  override lazy val condition: Condition = Condition(socketGroup = "RGB")
  override lazy val chaosValue: Future[Option[Double]] = Currencies.getByName("Chromatic Orb").map(_.chaosValuePerSlot)
}
