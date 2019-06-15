package me.amuxix.items.currency

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.ItemFilter.ec
import me.amuxix.database.Essences
import me.amuxix.items.{Currency, PriceFallback}

import scala.concurrent.Future

case class Essence(name: String, upgradesTo: Option[String], dropEnabled: Boolean) extends Currency with PriceFallback {
  override val stackSize: Int = 1
  override val dropLevel: Int = 1

  override def fallback: OptionT[Future, Double] =
    for {
      upgrade <- OptionT.fromOption[Future](upgradesTo)
      essence <- OptionT(Essences.all.map(_.find(_.name == upgrade)))
      value <- essence.chaosValuePerSlot
    } yield value / 3
}
