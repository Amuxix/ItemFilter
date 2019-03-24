package me.amuxix.items

abstract class MapFragment extends Item with Dimensions with ProviderPrice {
  override val dropLevel: Int = 1
  override val height: Int = 1
  override val width: Int = 1
}
