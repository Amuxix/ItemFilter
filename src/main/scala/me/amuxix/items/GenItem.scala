package me.amuxix.items
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

abstract class GenItem extends ImplicitConversions {
  def chaosValuePerSlot: Option[Double]

  def condition: Condition

  lazy val rarity: FilterRarity =
    chaosValuePerSlot.fold[FilterRarity](Undetermined) { chaosValuePerSlot =>
      if (chaosValuePerSlot >= Mythic.threshold) Mythic
      else if (chaosValuePerSlot >= Epic.threshold) Epic
      else if (chaosValuePerSlot >= Rare.threshold) Rare
      else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
      else if (chaosValuePerSlot >= Common.threshold) Common
      else Leveling //The price is lower than the lowest threshold.
    }

  def block(actionForRarity: FilterRarity => Action, filterLevel: FilterLevel): Block =
    Block(
      condition,
      actionForRarity(rarity),
      rarity >= filterLevel.cutoffRarity
    )
}