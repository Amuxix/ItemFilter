package me.amuxix.conditions

object AnyEnchantment {
}

case class AnyEnchantment(is: Boolean) extends ItemType[AnyEnchantment] {
  override def merge(other: AnyEnchantment): AnyEnchantment = this
}
