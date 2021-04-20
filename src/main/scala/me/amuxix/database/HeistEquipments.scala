package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.Equipment
import me.amuxix.database.types.Equipment.EquipmentType
import me.amuxix.database.types.Job.JobType
import me.amuxix.items.HeistEquipment
import me.amuxix.items.heist._

class HeistEquipmentTable(tag: Tag) extends Table[HeistEquipment](tag, "heist_equipment") with CommonColumns[HeistEquipment] {
  def jobType = column[JobType]("job_type")
  def jobLevel = column[Int]("job_level")
  def gearType = column[EquipmentType]("equipment_type")
  def dropLevel = column[Int]("drop_level")

  private def apply(
    name: String,
    jobType: JobType,
    jobLevel: Int,
    gearType: EquipmentType,
    dropLevel: Int,
    dropEnabled: Boolean
  ): HeistEquipment = gearType match {
    case Equipment.Cloak => Cloak(name, jobType, jobLevel, dropLevel, dropEnabled)
    case Equipment.Brooch => Brooch(name, jobType, jobLevel, dropLevel, dropEnabled)
    case Equipment.Tool => Tool(name, jobType, jobLevel, dropLevel, dropEnabled)
    case Equipment.Gear => Gear(name, jobType, jobLevel, dropLevel, dropEnabled)
  }

  def unapply(arg: HeistEquipment): Option[(String, JobType, Int, EquipmentType, Int, Boolean)] = ???

  override def * =
    (
      name,
      jobType,
      jobLevel,
      gearType,
      dropLevel,
      dropEnabled,
      ) <> ((apply _).tupled, unapply)
}

object HeistEquipments extends BasicOperations[HeistEquipment, HeistEquipmentTable](new HeistEquipmentTable(_))