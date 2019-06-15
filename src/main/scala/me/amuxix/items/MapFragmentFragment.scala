package me.amuxix.items

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.ItemFilter.ec
import me.amuxix.database.MapFragments
import me.amuxix.database.types.MapFragment.MapFragmentType

import scala.concurrent.Future

case class MapFragmentFragment(
  name: String,
  stackSize: Int,
  fragmentOf: String,
  fragmentType: MapFragmentType,
  dropEnabled: Boolean,
) extends Currency
    with PriceFallback {
  override val dropLevel: Int = 1

  override def fallback: OptionT[Future, Double] =
    for {
      mapFragment <- OptionT(MapFragments.all.map(_.find(_.name == fragmentOf)))
      value <- mapFragment.chaosValuePerSlot
    } yield value / stackSize
}
