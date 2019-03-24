package me.amuxix.items
import me.amuxix.{FilterRarity, Leveling}

import scala.concurrent.Future

case class Gem(
  name: String,
  dropLevel: Int,
  level: Int,
  dropEnabled: Boolean,
  quality: Option[Int] = None,
) extends Item with Quality {
  override val rarity: Future[FilterRarity] = Future.successful(Leveling)
}
