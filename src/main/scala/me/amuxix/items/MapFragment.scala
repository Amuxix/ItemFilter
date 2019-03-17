package me.amuxix.items

import me.amuxix.conditions.Condition

case class MapFragment(_name: String, fragmentType: String, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) {
  override val condition: Condition = Condition(base = _name)
}
