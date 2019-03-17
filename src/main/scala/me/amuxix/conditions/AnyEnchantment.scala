package me.amuxix.conditions

object AnyEnchantment {
  implicit def boolean2AnyEnchantment(boolean: Boolean): AnyEnchantment = AnyEnchantment(boolean)
}

case class AnyEnchantment(is: Boolean) extends ItemType(is)
