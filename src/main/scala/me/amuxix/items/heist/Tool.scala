package me.amuxix.items.heist

import me.amuxix.database.types.Job.JobType
import me.amuxix.items.HeistEquipment

case class Tool(
  name: String,
  jobType: JobType,
  jobLevel: Int,
  dropLevel: Int,
  dropEnabled: Boolean
) extends HeistEquipment {
  override val `class`: String = "Heist Tool"
}
