package me.amuxix.items
import me.amuxix.{FilterRarity, Mythic}

import scala.concurrent.Future

case class Watchstone(name: String, dropEnabled: Boolean) extends Item {
  override val dropLevel: Int = 1

  override val rarity: Future[FilterRarity] = Future.successful(Mythic)

  override val `class`: String = "Atlas Region Upgrade Item"
}
