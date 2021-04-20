package me.amuxix.items.heist

import me.amuxix.database.types.Job.JobType

case class Gear(
  name: String,
  jobType: JobType,
  jobLevel: Int,
  dropLevel: Int,
  dropEnabled: Boolean
) extends HeistEquipment {
  override val `class`: String = "Heist Gear"
}
