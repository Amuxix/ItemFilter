package me.amuxix.items
import me.amuxix.{Block, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.Condition

import scala.concurrent.Future

abstract class GenericItem {
  def rarity: Future[FilterRarity]
  def condition: Future[Condition]

  def block(actionForRarity: FilterRarity => Action): Future[Block] =
    for {
      rarity <- rarity
      condition <- condition
    } yield Block(condition, actionForRarity(rarity), rarity)
}
