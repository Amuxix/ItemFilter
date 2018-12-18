package me.amuxix.items.currency

import me.amuxix.items.{Item, NoPrice}

abstract class Currency(val stackSize: Int) extends Item(1, 1, "Currency")

case object Prophecy extends Currency(1) with NoPrice