package me.amuxix.items

abstract class Currency extends Item with Dimensions with Stackable with ProviderPrice {
  override val height: Int = 1
  override val width: Int = 1
  val stackSize: Int
}
