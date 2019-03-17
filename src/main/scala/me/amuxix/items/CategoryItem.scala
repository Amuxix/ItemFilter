package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.{FilterRarity, Undetermined}

import scala.concurrent.Future

abstract class CategoryItem(itemRarity: FilterRarity = Undetermined) extends GenItem("") {
  override lazy val chaosValuePerSlot: OptionT[Future, Double] = OptionT.none[Future, Double] //This is never be used because we override rarity

  override lazy val rarity: Future[FilterRarity] = Future.successful(itemRarity)
}
