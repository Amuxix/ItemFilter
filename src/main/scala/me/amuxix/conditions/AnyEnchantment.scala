package me.amuxix.conditions

import me.amuxix.Mergeable

object AnyEnchantment {
  implicit val mergeable: Mergeable[AnyEnchantment] = Mergeable.equal(_.is)
}

case class AnyEnchantment(is: Boolean) extends ItemType[AnyEnchantment]
