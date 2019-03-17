package me.amuxix.items

case class Currency(_name: String, stackSize: Int, currencyType: String, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) with StackSize