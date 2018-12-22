package me.amuxix.categories.automated.recipes
import me.amuxix.ItemFilter
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

import scala.concurrent.Future

object Whetstone extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.config.weaponClasses, quality = 20)
  override lazy val chaosValue: Future[Option[Double]] = Currencies.getByName("Blacksmith's Whetstone").map(_.chaosValuePerSlot)
}
