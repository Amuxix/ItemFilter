package me.amuxix.items

import me.amuxix.conditions.Condition

class MapFragment(name: String, val fragmentType: String) extends Item(name, 1, 1, "Currency") {
  override val condition: Condition = Condition(base = name)
}

object MapFragment {
  def apply(name: String, fragmentType: String): MapFragment = new MapFragment(name, fragmentType)

  def unapply(arg: MapFragment): Option[(String, String)] = Some((arg.name, arg.fragmentType))
}
