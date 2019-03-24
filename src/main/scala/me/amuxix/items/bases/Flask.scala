package me.amuxix.items.bases
import me.amuxix.items.{CraftableBase, Quality}

abstract class Flask extends CraftableBase with Quality {
  override val height: Int = 2
  override val width: Int = 1
  override val itemLevel: Option[Int] = None
}
