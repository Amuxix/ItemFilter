package me.amuxix.items
import me.amuxix.{FilterRarity, Undetermined}

import scala.concurrent.Future

abstract class Base extends Item with Dimensions with Uniques {
  override lazy val rarity: Future[FilterRarity] =
    Future.successful(Undetermined)
  override lazy val `class`: String = className
}
