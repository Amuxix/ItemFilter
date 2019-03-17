package me.amuxix.categories.semiautomated.recipes

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies

import scala.concurrent.Future

object Scrap extends Sized {
  override lazy val condition: Condition = Condition(`class` = ItemFilter.config.armourClasses ++ ItemFilter.config.shieldClasses, quality = 20)
  override lazy val chaosValue: OptionT[Future, Double] = Currencies.getByName("Armourer's Scrap").flatMap(_.chaosValuePerSlot)
}
