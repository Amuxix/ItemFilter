package me.amuxix.items

import cats.implicits._
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.currency.Currency
import me.amuxix.providers.Provider

import scala.concurrent.{ExecutionContext, Future}

abstract class Item(val size: ItemSize, val show: Boolean = true) extends Named with ImplicitConversions {
  val `class`: Option[conditions.ItemClass]
  def actionForRarity(rarity: FilterRarity): Action
  /*
  rarity match {
    case Mythic =>
    case Epic =>
    case Rare =>
    case Uncommon =>
    case Common =>
    case Undetermined =>
  }
   */
  val condition: Condition = Condition(`class` = `class`, base = name)

  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  def chaosValuePerSlot(implicit provider: Provider, ec: ExecutionContext): Future[Option[Double]] =
    provider.getChaosEquivalentFor(this).map(_ / size.area).value

  def rarity(filterThreshold: Double)(implicit provider: Provider, ec: ExecutionContext): Future[FilterRarity] =
    chaosValuePerSlot.map { possibleValue =>
      val value = possibleValue.getOrElse(0.0) / filterThreshold
      if (value >= Mythic.multiplier) Mythic
      else if (value >= Epic.multiplier) Epic
      else if (value >= Rare.multiplier) Rare
      else if (value >= Uncommon.multiplier) Uncommon
      else if (value >= Common.multiplier) Common
      else Undetermined
    }

  def block(filterLevel: FilterLevel, filterThreshold: Double)(implicit provider: Provider, ec: ExecutionContext): Future[Block] =
    rarity(filterThreshold).map { rarity =>
      Block(condition, actionForRarity(rarity), show)
    }
}

object Item {
  val items = Currency.currency ++ DivinationCard.divCards
}
