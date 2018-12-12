package me.amuxix.items.currency

import me.amuxix.items.Item

/**
  * This is the parent of all currency marker traits.
  */
abstract class Currency(val stackSize: Int) extends Item(1, 1, "Currency")