package me.amuxix.items

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.database.Bases
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.{Condition, Unique}

import scala.concurrent.Future

case class UniqueItem(name: String, baseName: String, dropEnabled: Boolean, league: Option[String]) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override val area: OptionT[Future, Int] =
    Bases.getByName(baseName).flatMap(_.area)
  override val `class`: String = ""
  override def condition: Future[Condition] =
    Future.successful(
      Condition(
        base = baseName,
        rarity = Unique,
      )
    )
}
