package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

import scala.concurrent.Future

abstract class GenItem(val name: String = "", val dropEnabled: Boolean = true) extends ImplicitConversions {
  def chaosValuePerSlot: OptionT[Future, Double]

  def condition: Condition

  lazy val rarity: Future[FilterRarity] =
    chaosValuePerSlot.fold[FilterRarity](Undetermined) { chaosValuePerSlot =>
      if (chaosValuePerSlot >= Mythic.threshold) Mythic
      else if (chaosValuePerSlot >= Epic.threshold) Epic
      else if (chaosValuePerSlot >= Rare.threshold) Rare
      else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
      else if (chaosValuePerSlot >= Common.threshold) Common
      else Leveling //The price is lower than the lowest threshold.
    }

  def block(actionForRarity: FilterRarity => Action): Future[Block] =
    rarity.map { rarity =>
      Block(condition, actionForRarity(rarity), rarity)
    }
}
