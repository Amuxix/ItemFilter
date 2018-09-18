package me.amuxix.items.currency

import me.amuxix.conditions.Condition
import me.amuxix.items.Item

/**
  * This is the parent of all currency marker traits.
  */
abstract class Currency extends Item(1, 1) {
  override protected lazy val condition: Condition = Condition(`class` = "Currency", base = name)
}