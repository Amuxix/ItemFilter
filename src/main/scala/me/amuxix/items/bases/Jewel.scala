package me.amuxix.items.bases
import me.amuxix.items.{Corruptible, CraftableBase}

abstract class Jewel extends CraftableBase with Corruptible {
  override val dropLevel: Int = 1
  override val height: Int = 1
  override val width: Int = 1
}
