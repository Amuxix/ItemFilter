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
class Essence(name: String, val upgradesTo: Option[String]) extends Item(name, 1, 1, "Currency") with PriceFallback {
  override lazy val condition: Condition = Condition(`class` = "Currency", base = name)
  override def fallback: OptionT[Future, Double] =
    for {
      upgrade <- OptionT.fromOption[Future](upgradesTo)
      essence <- Essences.getByName(upgrade)
      value <- essence.chaosValuePerSlot
    } yield value / 3
}

object Essence {
  def apply(name: String, upgradesTo: Option[String]): Essence = new Essence(name, upgradesTo)

  def unapply(arg: Essence): Option[(String, Option[String])] = Some((arg.name, arg.upgradesTo))
}
