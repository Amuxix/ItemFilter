package me.amuxix

import me.amuxix.FilterRarity.Priced.{Common, Leveling, Rare, Uncommon}

sealed abstract case class FilterLevel(suffix: String, cutoffRarity: FilterRarity)

object Racing extends FilterLevel(" Leveling", Leveling)

object Normal extends FilterLevel("", Common)
object Diminished extends FilterLevel(" Diminished", Uncommon)
object Reduced extends FilterLevel(" Reduced", Rare)
