package me.amuxix

sealed abstract case class FilterLevel(suffix: String, cutoffRarity: FilterRarity)

object Racing extends FilterLevel(" Leveling", Leveling)

object Normal extends FilterLevel("", Common)
object Diminished extends FilterLevel(" Diminished", Uncommon)
object Reduced extends FilterLevel(" Reduced", Rare)
