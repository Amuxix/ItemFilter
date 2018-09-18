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
  lazy val condition: Condition = Condition(`class` = `class`, base = name)

  /**
    * This is the worth of the currency in chaos per slot the item has.
    */
  lazy val chaosValuePerSlot: Double =
    Provider.getChaosEquivalentFor(this).map(_ / size.area).value.fold[Double](0)(identity)

  lazy val rarity: FilterRarity = {
    if (chaosValuePerSlot >= Mythic.threshold) Mythic
    else if (chaosValuePerSlot >= Epic.threshold) Epic
    else if (chaosValuePerSlot >= Rare.threshold) Rare
    else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
    else if (chaosValuePerSlot >= Common.threshold) Common
    else Undetermined
  }

  lazy val block: Block = Block(condition, actionForRarity(rarity), show)
}

object Item {
  val items = Currency.currency ++ DivinationCard.divCards
}
