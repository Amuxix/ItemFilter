package me.amuxix.items.bases
import me.amuxix.items._

abstract class Weapon extends CraftableBase with Corruptible with Quality with Sockets with Variations {
  override val itemLevelToUnlockTopModTiers: Int = 83
}