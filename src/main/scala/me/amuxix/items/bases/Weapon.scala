package me.amuxix.items.bases
import me.amuxix.items.{Corruptible, CraftableBase, Quality, Sockets}

abstract class Weapon extends CraftableBase with Corruptible with Quality with Sockets {
  override val itemLevelToUnlockTopModTiers: Int = 83
}