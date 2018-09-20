package me.amuxix.items
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

/**
  * This is the worth of the currency in chaos per slot the item has.
  */
abstract class GenItem(val rarity: FilterRarity = Undetermined) extends Named with ImplicitConversions {
  protected def condition: Condition

  def block(actionForRarity: FilterRarity => Action, filterLevel: FilterLevel): Block = Block(condition, actionForRarity(rarity), rarity >= filterLevel.cutoffRarity)
}