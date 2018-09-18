package me.amuxix

sealed abstract case class FilterLevel(suffix: String, cutoffRarity: FilterRarity = Common)

object Racing extends FilterLevel(" Leveling")

object Normal extends FilterLevel("")
object Reduced extends FilterLevel(" Reduced", Rare)
