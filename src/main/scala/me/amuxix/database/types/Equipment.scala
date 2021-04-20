package me.amuxix.database.types

object Equipment extends Enumeration {
  type EquipmentType = Value
  val Cloak = Value("Cloak")
  val Brooch = Value("Brooch")
  val Tool = Value("Tool")
  val Gear = Value("Gear")
}
