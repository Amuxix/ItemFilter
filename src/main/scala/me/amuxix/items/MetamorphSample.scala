package me.amuxix.items

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

case class MetamorphSample(name: String, dropEnabled: Boolean) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override val area: OptionT[Future, Int] = OptionT.pure[Future](1)
  override val `class`: String = "Metamorph Sample"
}
