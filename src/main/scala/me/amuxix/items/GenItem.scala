package me.amuxix.items
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

abstract class GenItem(_rarity: FilterRarity = Undetermined) extends Named with ImplicitConversions {
  lazy val rarity: FilterRarity = _rarity
  protected def condition: Condition

  def block(actionForRarity: FilterRarity => Action, filterLevel: FilterLevel): Block = Block(condition, actionForRarity(rarity), rarity >= filterLevel.cutoffRarity)
}