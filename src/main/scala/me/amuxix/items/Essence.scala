package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition
import me.amuxix.database.Essences

import scala.concurrent.Future

/**
  * Like [[Currency]] this currency can enhance items but they themselves can also be upgraded.
  */
case class Essence(_name: String, upgradesTo: Option[String], _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) with PriceFallback {
  override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Currency", base = _name))
  override def fallback: OptionT[Future, Double] =
    for {
      upgrade <- OptionT.fromOption[Future](upgradesTo)
      essence <- Essences.getByName(upgrade)
      value <- essence.chaosValuePerSlot
    } yield value / 3
}
