package me.amuxix.items

import me.amuxix.database.types.MapFragment.MapFragmentType
import me.amuxix.providers.Provider

case class MapFragmentFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  fragmentType: MapFragmentType,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  override def fallback(provider: Provider): Option[Double] =
  for {
    mapFragment <- provider.mapFragments.all.find(_.name == fragmentOf)
    value <- mapFragment.chaosValuePerSlot(provider)
  } yield value / stackSize

  override val itemType: String = fragmentType.toString
}
