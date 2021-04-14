package me.amuxix.items

import cats.data.OptionT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.{AlwaysShow, FilterRarity}
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

case class MetamorphSample(name: String, dropEnabled: Boolean) extends Item with Area {
  override val dropLevel: Int = 1
  override val area: OptionT[Future, Int] = OptionT.pure[Future](1)
  override val `class`: String = "Metamorph Sample"

  override def rarity: Future[FilterRarity] = Future.successful(AlwaysShow)
}
