package me.amuxix

sealed abstract case class FilterLevel(suffix: String, cutoffRarity: FilterRarity, id: String)

object Racing extends FilterLevel(" Leveling", Leveling, ItemFilter.settings.ggg.racingId)

object Normal extends FilterLevel("", Common, ItemFilter.settings.ggg.normalId)
object Diminished extends FilterLevel(" Diminished", Uncommon, ItemFilter.settings.ggg.diminishedId)
object Reduced extends FilterLevel(" Reduced", Rare, ItemFilter.settings.ggg.reducedId)
