package me.amuxix.items

import me.amuxix.{FilterRarity, Undetermined}
import me.amuxix.database.types.Job.JobType
import me.amuxix.providers.Provider

abstract class HeistEquipment extends Item {
  def jobType: JobType
  def jobLevel: Int
  //override val `class`: String = "Heist Cloak\" \"Heist Brooch\" \"Heist Tool\" \"Heist Gear"
  override def rarity(provider: Provider): FilterRarity = Undetermined
}
