package me.amuxix.items

import me.amuxix.{Block, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

abstract class GenericItem { item =>
  def rarity(provider: Provider): FilterRarity
  def condition: Condition

  def block(provider: Provider, actionForRarity: FilterRarity => Action): Block = {
    val rarity = item.rarity(provider)
    Block(condition, actionForRarity(rarity), rarity)
  }
}
